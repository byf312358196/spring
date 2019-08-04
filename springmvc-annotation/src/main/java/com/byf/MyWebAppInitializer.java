package com.byf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.byf.config.AppConfig;
import com.byf.config.RootConfig;


public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// ��ȡ�������������ࣺ��Spring�������ļ���������
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}
	// ��ȡweb�����������ࣨSpringMVC�����ļ���������
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}
	// ��ȡDispatcherServlet��ӳ����Ϣ
	/**
	 *	//:�����������󣨰�����̬��Դ��xx.js,xx.png������������*.jsp
	 *	//*������
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
