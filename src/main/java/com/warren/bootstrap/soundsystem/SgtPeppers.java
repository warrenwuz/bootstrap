package com.warren.bootstrap.soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/31 13:59
 */
public class SgtPeppers implements CompactDisc {
	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

	@Override
	public void playTrack(int trackNumber) {
	}
}
