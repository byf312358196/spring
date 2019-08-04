package com.byf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.byf.controller.MyFirstInterceptor;

// SpringMVCֻɨ��Controller������
// useDefaultFilters=false ����Ĭ�Ϲ��˹���
@ComponentScan(value="com.byf", includeFilters={
		@Filter(type=FilterType.ANNOTATION,classes={Controller.class})
},useDefaultFilters=false)
@EnableWebMvc
@Async
public class AppConfig extends WebMvcConfigurerAdapter{
	// ����
	
	// ��ͼ������
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// Ĭ������ҳ�涼��/WEB-INF / xx.jsp
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	
	// ��̬��Դ����
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	// ������
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
	}
}
