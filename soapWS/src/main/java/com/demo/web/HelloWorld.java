package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.demo.service.PaymentService;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	int count=0;
	
	Object locker = new Object();
    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String result = config.getInitParameter("debugUsers");
		System.out.println(result);
		context = config.getServletContext();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String paremeter = request.getParameter("action");
//		PrintWriter writer = response.getWriter();
//		writer.append("<html><body><h2>Apache CXF Web Services</h2></body></html>");
//		writer.flush();
//		writer.close();
//		System.out.println("DoGet");
		String parameter = request.getParameter("action");
		HttpSession session = request.getSession();
		String id = session.getId();
		System.out.println("session id "+ id);
		synchronized(locker) {
			count++;
			System.out.print("==========");
		}
		
		WebApplicationContext webContext = WebApplicationContextUtils.getWebApplicationContext(context);
		PaymentService jobbie = (PaymentService)webContext.getBean("paymentServiceImpl");
		PaymentService jobbie2 = (PaymentService)webContext.getBean("paymentServiceImpl");
		
		boolean isNewSession = session.isNew();
		System.out.println(isNewSession + "    " + id);
		session.setAttribute("user", "test");
		session.setMaxInactiveInterval(30*60);
		Cookie userName = new Cookie("user", "test");
		response.addCookie(userName);

		String encodedURL = response.encodeRedirectURL("LoginSuccess.jsp");
		response.sendRedirect(encodedURL);
		        
//		if(parameter!=null && parameter.equals("forward"))
//		{
//			  String s = "abc";
//			  request.setAttribute("title", s);
//	          RequestDispatcher dispatcher = context.getRequestDispatcher("/hello.jsp");
//	          dispatcher.forward(request, response);
//		}
//		else if(parameter!=null && parameter.equals("redirect"))
//		{
//			response.sendRedirect("http://localhost:8080/soapWS/hello.jsp");
//		}
//		else{
//			  parameter = "wrong page!";
//			  PrintWriter writer = response.getWriter();
//			  writer.append("<html><body><t1>" + parameter + "</t1></body></html>");
//			  writer.flush();
//			  writer.close();
//			  System.out.println("DoGet");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("doPost");
	}

}
