package com.warren.bootstrap.spittr;

import com.warren.bootstrap.spittr.data.Spittle;
import com.warren.bootstrap.spittr.data.SpittleRepository;
import com.warren.bootstrap.spittr.web.SpittleController;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/13 11:17
 */
public class SpittleControllerTest {
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<>();
		for (int i=0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}
	@Test
   	public void shouldShowRecentSpittles(){
		List<Spittle> spittleList = createSpittleList(20);
		SpittleRepository spittleRepository= Mockito.mock(SpittleRepository.class);
		Mockito.when(spittleRepository.findSpittles(Long.MAX_VALUE,20)).thenReturn(spittleList);
		SpittleController spittleController=new SpittleController(spittleRepository);
			MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).
				setSingleView(new InternalResourceView("WEB-INF/views/spittles")).build();
		try {
			mockMvc.perform(get("/spittles")).
				andExpect(view().name("spittles")).
				andExpect(model().attributeExists("spittleList")).
				andExpect(model().attribute("spittleList",hasItems(spittleList.toArray())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void shouldShowPagedSpittles(){
		List<Spittle> spittleList = createSpittleList(50);
		SpittleRepository spittleRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(spittleRepository.findSpittles(238900,50)).thenReturn(spittleList);
		SpittleController spittleController=new SpittleController(spittleRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).
			setSingleView(new InternalResourceView("WEB-INF/views/spittles")).build();
		try {
			mockMvc.perform(get("/spittles?max=238900&count=50")).
				andExpect(view().name("spittles")).
				andExpect(model().attributeExists("spittleList")).
				andExpect(model().attribute("spittleList",hasItems(spittleList.toArray())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSpittle(){
		Spittle spittle=new Spittle("Hello",new Date());
		SpittleRepository spittleRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(spittleRepository.findOne(789)).thenReturn(spittle);
		SpittleController spittleController=new SpittleController(spittleRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).
			build();
		try {
			mockMvc.perform(get("/spittles/12345")).
				andExpect(view().name("spittle")).
				andExpect(model().attributeExists("spittle")).
				andExpect(model().attribute("spittle",spittle));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
