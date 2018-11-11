package com.warren.bootstrap.aop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/5 9:49
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
	public class AopConfigTest {

	@Autowired
	private Audience audience;
	@Autowired
	private Actor actor;

	@Test
	public void testAudience() {
	  actor.preform();
	}
	@Test
	public void testEat() {
	  actor.eat();
	}
}
