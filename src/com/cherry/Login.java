package com.cherry;
//New Patient Registry Management System
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/log")
public class Login extends HttpServlet{
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String usr="";
		String user = request.getParameter("n1");
		String pass = request.getParameter("p1");
		String qry="select * from patientapp.register where pname=? and password=?";
		    HttpSession session = request.getSession();
		    session.setAttribute("userName", user);
		    String userName = (String) session.getAttribute("userName");
		    System.out.println(userName);
		  PrintWriter pw = response.getWriter();
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("jdbc code starts");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
				System.out.println("connected");
				PreparedStatement ps = con.prepareStatement(qry);
				System.out.println("platform");
				ps.setString(1, user);
				ps.setString(2,pass);
				System.out.println("aaaa");
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
				usr = rs.getString("pname");
				System.out.println("welcome  "+usr);
				// PrintWriter pw = response.getWriter();   
				  pw.println("<html><body><h1>"+"welcome "+ usr +"</h1></body></html>");
				  pw.println("<html><body><h1>enter details <a href='/Patientapp/patdetails.html'> here</a></h1></body></html>");
				}
				else
				{
					System.err.println("invalid user");
					pw.println("<html><body><h1>"+"invalid user"+"</h1></body></html>");
				}
				
		 
			}
			 catch(ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		}
}
