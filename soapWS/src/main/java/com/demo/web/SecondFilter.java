package com.demo.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class SecondFilter
 */
public class SecondFilter implements Filter {
	long startTime = 0;
	long endTime = 0;
	
    /**
     * Default constructor. 
     */
    public SecondFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		startTime =  System.currentTimeMillis();
		
        HttpServletRequest req = (HttpServletRequest) request;
         
        String url = ((HttpServletRequest)request).getRequestURL().toString();
         
        System.out.println("url "+ url);
         
        chain.doFilter(request, response);
        
        endTime  = System.currentTimeMillis();
        
        long time = endTime - startTime;
        
        System.out.println("time" + time);
        
        System.out.println("see what happens");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		String testParam = fConfig.getInitParameter("test-param");
		System.out.println("Test Param:" + testParam);
	}

}
