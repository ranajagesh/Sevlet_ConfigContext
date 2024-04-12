package com.java.servle.ServletConfig_Context;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hi")
public class Servlet1 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		String url = sc.getInitParameter("dburl");
		String dname = sc.getInitParameter("dname");
		String pass = sc.getInitParameter("dpassword");
		
		System.out.println("Servlet 1.........");
		System.out.println(url);
		System.out.println(dname);
		System.out.println(pass);
		
		RequestDispatcher rd = req.getRequestDispatcher("/servlet1");
		rd.forward(req, res);
		
	}

}
