package com.warren.bootstrap.aop;

import com.warren.bootstrap.soundsystem.CompactDisc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/5 11:02
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {
	@Autowired
	private CompactDisc cd;
	@Autowired
	private TrackCounter trackCounter;

	@Test
	public void testTrackCounter() {
		cd.playTrack(1);
		cd.playTrack(2);
		cd.playTrack(3);
		cd.playTrack(3);
		cd.playTrack(3);
		cd.playTrack(3);
		assertEquals(1, trackCounter.getPlayCount(1));
		assertEquals(1, trackCounter.getPlayCount(2));
		assertEquals(4, trackCounter.getPlayCount(3));
		assertEquals(0, trackCounter.getPlayCount(4));

	}
}
