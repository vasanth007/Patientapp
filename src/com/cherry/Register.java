package com.cherry;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cherry1.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class Register extends HttpServlet
{
 
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
 {
	 
		Connection con=null;
		PreparedStatement ps=null;
		
	 System.out.println("Servlet");
	 
		 String name=req.getParameter("n1");
	 String	pass=req.getParameter("a1");	
		 String sql="insert into patientapp.register values(?,?)";
		try 
		{
			con = Jdbc.connect();
			System.out.println("connected");
			ps = con.prepareStatement(sql);
			System.out.println("platform");
			ps.setString(1,name);
			ps.setString(2,pass);
	        ps.executeUpdate();
	        ps.close();
	        con.close();
	        System.out.println("1231455312313");
		 PrintWriter pw = resp.getWriter();   
		  pw.println("<html><body><h1>"+"registered your name= "+name+"</h1></body></html>");

		  pw.println("<html><body><h1>login <a href='/Patientapp/Login.html'> here</a></h1></body></html>");
 }
	 
		  catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				Close.CloseCon(con,ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
 
}
