package com.byf.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;



@WebServlet(value="/async",asyncSupported=true)
public class HelloAsyncServlet extends HttpServlet{


	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
		// 1��֧���첽����asyncSupported=true
		// 2�������첽ģʽ
		final AsyncContext startAsync = req.startAsync();
		// 3����ʼ�첽����
		startAsync.start(new Runnable(){

			@Override
			public void run() {
				try {
					sayHello();
					startAsync.complete();
					// ��ȡ���첽������
					AsyncContext asyncContext = req.getAsyncContext();
					// 4����ȡ��Ӧ
					ServletResponse response = asyncContext.getResponse();
					response.getWriter().write("Hello async...");
				} catch (InterruptedException | IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	};*/
	
	public void sayHello() throws InterruptedException{
		System.out.println(Thread.currentThread() + "processing...");
		Thread.sleep(3000);
	}
}
