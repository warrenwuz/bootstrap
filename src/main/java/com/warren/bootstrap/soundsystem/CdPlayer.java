package com.warren.bootstrap.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/31 14:29
 */
@Component
public class CdPlayer implements MediaPlayer {
	private CompactDisc cd;

	@Autowired
	public CdPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public void play() {
      cd.play();
	}
}
