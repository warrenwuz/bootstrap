package com.warren.bootstrap.aop;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/5 9:51
 */
@Slf4j
public class Actor implements Performance {
	@Override
	public void eat() {
		log.info("eat start");
	}

	@Override
	public void preform() {
		log.info("preform start");
	}
}
