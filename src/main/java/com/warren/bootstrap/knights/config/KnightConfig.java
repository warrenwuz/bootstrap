package com.warren.bootstrap.knights.config;

import com.warren.bootstrap.knights.BraveKnight;
import com.warren.bootstrap.knights.Knight;
import com.warren.bootstrap.knights.Quest;
import com.warren.bootstrap.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuzhe1159@163.com
 * @date 2018/10/31 9:02
 * @since jdk11
 */
@Configuration
public class KnightConfig {
	@Bean
	public Knight knight(){
		return new BraveKnight(quest());
	}
	@Bean
	public Quest quest(){
		return new SlayDragonQuest(System.out);
	}
}
