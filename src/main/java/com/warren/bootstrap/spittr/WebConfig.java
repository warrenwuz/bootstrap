package com.warren.bootstrap.spittr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/11 10:45
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.warren.bootstrap.spittr")
public class WebConfig extends WebMvcConfigurationSupport {
	///
	/*@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver(){}

		resourceViewResolver.setPrefix("/WEB-INF/views/");
		resourceViewResolver.setSuffix(".jsp");
		return resourceViewResolver;
	}*/
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver() {
			ThreadLocal<String> viewNameLocal = new ThreadLocal<>();
			@Override
			protected AbstractUrlBasedView buildView(String viewName) throws Exception {
				try {
					viewNameLocal.set(viewName);
					return super.buildView(viewName);
				} finally {
					viewNameLocal.remove();
				}
			}
			@Override
			protected String getPrefix() {
				String prefix = super.getPrefix();
				String viewName = viewNameLocal.get();
				if (viewName != null) {
					if (viewName.startsWith(prefix)) {
						return "";
					}
					if (viewName.startsWith("jsp/") && prefix.endsWith("jsp/")) {
						return prefix.substring(0, prefix.length() - "jsp/".length());
					}
				}
				return prefix;
			}

			@Override
			protected String getSuffix() {
				String suffix = super.getSuffix();
				String viewName = viewNameLocal.get();
				if (viewName != null) {
					if (viewName.endsWith(suffix)) {
						return "";
					}
					if (viewName.endsWith(".html")) {
						return "";
					}
				}
				return suffix;
			}
		};
		resolver.setOrder(2);
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		resolver.setContentType("text/html; charset=UTF-8");
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
