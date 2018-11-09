package com.warren.bootstrap.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/4 17:56
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConcertConfig {
	@Bean
	public Audience audience(){
		return new Audience();
	}
	@Bean
	public Actor actor(){
		return new Actor();
	}
}
