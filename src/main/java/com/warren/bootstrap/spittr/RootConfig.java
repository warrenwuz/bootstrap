package com.warren.bootstrap.spittr;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author wuzhe1159@163.com
 * @date 2018/11/11 10:45
 */
@Configuration
@ComponentScan(basePackages={"spittr"})
public class RootConfig {

}
