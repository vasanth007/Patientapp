package com.cherry;

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

@WebServlet("/det")
public class Details extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
	 
		
	 System.out.println("Servlet");
		String name=req.getParameter("n1");
		String	age=req.getParameter("a1");	
		String disease=req.getParameter("d");
		String 	date=req.getParameter("d1");
		
		 String sql="insert into patientapp.patient_details values(?,?,?,?)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("jdbc code starts");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
			System.out.println("connected");
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("platform");
			ps.setString(1,name);
			ps.setString(2,age);
			ps.setString(3,disease);
			ps.setString(4,date);
	        ps.executeUpdate();
		 PrintWriter pw = resp.getWriter();   
		  pw.println("<html><body><h1>"+"details stored your name= "+name+"</h1></body></html>");
		  pw.println("<html><body><h1>login <a href='/Patientapp/CheckDetails.html'> here</a></h1></body></html>");
		 
 }
	 
		  catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
 
}

