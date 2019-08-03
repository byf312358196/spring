package com.byf.servlet;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;

import com.byf.filter.UserFilter;
import com.byf.listener.UserListener;
import com.byf.service.HelloService;

@HandlesTypes({ HelloService.class,HttpServlet.class,Filter.class }) 
public class MyServletContainerInitializer implements ServletContainerInitializer{

	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext sc)
			throws ServletException {
		System.out.println("����Ȥ������");
		for(Class c : arg0) {
			System.out.println(c.getName());
		}
		// ע�����
		Dynamic servlet = sc.addServlet("userServlet", new UserServlet());
		// ����servlet��ӳ����Ϣ
		servlet.addMapping("/user");
		// ע�����
		sc.addListener(UserListener.class);
		// ע��Filter
		javax.servlet.FilterRegistration.Dynamic filter = sc.addFilter("userFilter", UserFilter.class);
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
	}
}
