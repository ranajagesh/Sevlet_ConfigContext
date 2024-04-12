package com.java.servle.ServletConfig_Context;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet4")
public class Servlet4 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ServletConfig con = getServletConfig();
		
		String s = con.getInitParameter("ADD_A2");
		System.out.println(s);
		
	}

}
