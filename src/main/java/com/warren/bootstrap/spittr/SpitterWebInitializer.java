package com.warren.bootstrap.spittr;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * {@link javax.servlet.ServletContainerInitializer} 代替web.xml
 * {@link javax.servlet.annotation.HandlesTypes} 在 {@link org.springframework.web.SpringServletContainerInitializer}中
 * 注解了{@link org.springframework.web.WebApplicationInitializer}
 * AbstractAnnotationConfigDispatcherServletInitializer 继承 {@link org.springframework.web.WebApplicationInitializer}
 * @author wuzhe1159@163.com
 * @date 2018/11/11 10:29
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
