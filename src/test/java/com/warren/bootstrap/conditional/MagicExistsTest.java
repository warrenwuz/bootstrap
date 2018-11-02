package com.warren.bootstrap.conditional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/2 9:21
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MagicConfig.class)
public class MagicExistsTest {
	@Autowired
	private ApplicationContext context;
	@Test
	public void shouldNotBeNull(){
		Assert.assertTrue(context.containsBean("magicBean"));
	}
}
