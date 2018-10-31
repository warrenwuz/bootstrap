package com.warren.bootstrap.knights;

import java.io.PrintStream;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/31 10:04
 * @since jdk11
 */
public class Minstrel {
	private PrintStream printStream;
	public Minstrel(PrintStream printStream){
		this.printStream=printStream;
	}
	public void singBeforeQuest() {
		printStream.println("Fa la la, the knight is so brave!");
	}

	public void singAfterQuest() {
		printStream.println("Tee hee hee, the brave knight " +
			"did embark on a quest!");
	}
}
