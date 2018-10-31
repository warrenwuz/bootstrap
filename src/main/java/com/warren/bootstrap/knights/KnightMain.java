package com.warren.bootstrap.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/31 9:11
 * @since jdk11
 */
public class KnightMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("minstrel.xml");
		Knight knight=context.getBean(Knight.class);
		knight.embarkOnQuest();
		context.close();
	}
}
