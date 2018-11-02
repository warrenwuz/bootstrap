package com.warren.bootstrap.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/2 9:08
 */
@Configuration
public class MagicConfig {
	@Bean
	@Conditional(MagicExistsCondition.class)
	public MagicBean magicBean(){
		return new MagicBean();
	}
}
