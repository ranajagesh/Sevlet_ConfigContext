package com.java.servle.ServletConfig_Context;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet1")
public class Servlet2 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String url = sc.getInitParameter("dburl");
		String dname = sc.getInitParameter("dname");
		String pass = sc.getInitParameter("dpassword");
		
		System.out.println("Servlet 2.........");
		System.out.println(url);
		System.out.println(dname);
		System.out.println(pass);
		
		RequestDispatcher rd = req.getRequestDispatcher("/servlet2");
		rd.forward(req, res);
	}

}
