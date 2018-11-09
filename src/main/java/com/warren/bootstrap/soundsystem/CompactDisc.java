package com.warren.bootstrap.soundsystem;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/31 13:59
 */

public interface CompactDisc {
	/**
	 * play
	 */
	void play();

	/**
	 * 播放磁道
	 * @param trackNumber
	 */
	void playTrack(int trackNumber);
}
