package com.warren.bootstrap.spittr;

import com.warren.bootstrap.spittr.web.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/13 9:03
 */
public class HomeControllerTest {
	@Test
	public void testHomePage(){
		HomeController homeController=new HomeController();
		MockMvc mockMvc= MockMvcBuilders.standaloneSetup(homeController).build();
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/homePage")).andExpect(MockMvcResultMatchers.view().name("home"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
