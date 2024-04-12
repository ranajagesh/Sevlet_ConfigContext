package com.servlet.DataInsert_ServletContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

@WebServlet("/context")
public class ServletContextData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		ServletContext sc = getServletContext();
		String url = sc.getInitParameter("dburl");
		String dname = sc.getInitParameter("dname");
		String password = sc.getInitParameter("dpassword");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dname,password);
			PreparedStatement ps = con.prepareStatement("insert into user (id ,Name,email,Password) values (?,?,?,?)");
			
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, pass);
			
			if(!ps.execute()) {
				resp.getWriter().write("Data Added Successfully!");
			} else {
				PrintWriter pw = resp.getWriter();
				pw.print("Invalid Crenditials");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}	
}
