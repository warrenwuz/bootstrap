package com.warren.bootstrap.soundsystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/31 14:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CdPlayerConfig.class)
public class CdPlayerTest {

	@Autowired
	private MediaPlayer player;
	@Autowired
	private CompactDisc cd;
	@Test
	public void cdShouldNotBeNull(){
		Assert.assertNotNull(cd);
	}
	@Test
	public void play(){
		player.play();
	}
}
