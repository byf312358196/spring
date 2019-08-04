package com.byf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyFirstInterceptor implements HandlerInterceptor {

	// Ŀ�귽������֮ǰִ��
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("MyFirstInterceptor ... preHandle" +request.getRequestURI());
		return true;
	}

	// Ŀ�귽��ִ����ȷ�Ժ�ִ��
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyFirstInterceptor ... postHandle ");
	}
	
	// ҳ����Ӧ�Ժ�
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyFirstInterceptor ... afterCompletion");
	}

}
