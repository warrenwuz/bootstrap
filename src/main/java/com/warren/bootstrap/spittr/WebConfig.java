package com.warren.bootstrap.spittr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/11 10:45
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.warren.bootstrap.spittr")
public class WebConfig extends WebMvcConfigurationSupport {
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/WEB-INF/views/");
		resourceViewResolver.setSuffix(".jsp");
		return resourceViewResolver;
	}

	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
