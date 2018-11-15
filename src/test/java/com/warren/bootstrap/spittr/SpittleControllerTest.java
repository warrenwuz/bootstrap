package com.warren.bootstrap.spittr;

import com.warren.bootstrap.spittr.data.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/13 11:17
 */
public class SpittleControllerTest {
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i=0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}
}
