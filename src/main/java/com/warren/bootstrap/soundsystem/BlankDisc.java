package com.warren.bootstrap.soundsystem;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/4 17:03
 */
@Data
@Slf4j
@NoArgsConstructor
public class BlankDisc implements CompactDisc {

	private String title;
	private String artist;
	private List<String> tracks;

	public BlankDisc(String title, String artist, List<String> tracks) {
		this.title = title;
		this.artist = artist;
		this.tracks = tracks;
	}

	@Override
	public void play() {
		log.info("Playing " + title + " by " + artist);
		for (String track : tracks) {
			log.info("-Track: " + track);
		}
	}

	@Override
	public void playTrack(int trackNumber) {
		log.info("Playing " + title + " by " + artist);
		log.info("Track----{}",this.tracks.get(trackNumber));
	}

}
