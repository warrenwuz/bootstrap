package com.warren.bootstrap.knights;

import java.io.PrintStream;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/31 8:54
 * @since jdk11
 */
public class SlayDragonQuest implements Quest{

	private PrintStream stream;

	public SlayDragonQuest(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void embark() {
		stream.println("Embarking on quest to slay the dragon!");
	}
}
