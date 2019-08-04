package com.byf.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/async",asyncSupported=true)
public class HelloAsyncServlet extends HttpServlet {
	
	@Override
	protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final long startTime = System.currentTimeMillis();
		//1��֧���첽����asyncSupported=true
		//2�������첽ģʽ
		System.out.println("���߳̿�ʼ������"+Thread.currentThread()+"==>" + "0ms");
		final AsyncContext startAsync = req.startAsync();
		
		//3��ҵ���߼������첽����;��ʼ�첽����
		startAsync.start(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("���߳̿�ʼ������"+Thread.currentThread()+"==>"+(System.currentTimeMillis() - startTime) + "ms");
					sayHello();
					
					//��ȡ���첽������
					AsyncContext asyncContext = req.getAsyncContext();
					//4����ȡ��Ӧ
					ServletResponse response = asyncContext.getResponse();
					response.getWriter().write("hello async...");
					startAsync.complete();
					System.out.println("���߳̽���������"+Thread.currentThread()+"==>"+(System.currentTimeMillis() - startTime) + "ms");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
		System.out.println("���߳̽���������"+Thread.currentThread()+"==>"+(System.currentTimeMillis() - startTime) + "ms");
	}

	public void sayHello() throws Exception{
		System.out.println(Thread.currentThread()+" processing...");
		Thread.sleep(3000);
	}
}
