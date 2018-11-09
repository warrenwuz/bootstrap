package com.warren.bootstrap.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/5 10:32
 */
@Aspect
public class TrackCounter {
	private Map<Integer, Integer> trackCounts = new HashMap<>();

	@Pointcut("execution(* com.warren.bootstrap.soundsystem.CompactDisc.playTrack(int))" + "&& args(trackNumber)")
	public void trackPlayed(int trackNumber) {
	}

	/**
	 * 统计播放
	 * @param trackNumber
	 */
	@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber) {
		int currentCount = getPlayCount(trackNumber);
		trackCounts.put(trackNumber, currentCount + 1);
	}

	public int getPlayCount(int trackNumber) {
		return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
	}
}
