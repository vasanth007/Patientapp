package com.cherry;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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

import com.cherry1.Close;
import com.cherry1.Jdbc;

@WebServlet("/ser")
public class Search extends HttpServlet
{
	protected void doPost(HttpServletRequest request,
		    HttpServletResponse response)
		        throws ServletException, IOException 
	{
		Connection con=null;
	PreparedStatement ps=null;
	
		String name = request.getParameter("t1");
		String qry="select * from patientapp.patient_details where pname=?";
		  PrintWriter pw = response.getWriter();
			try 
			{
				con = Jdbc.connect();
				System.out.println("connected");
				ps = con.prepareStatement(qry);
				System.out.println("platform");
				ps.setString(1, name);
				System.out.println("aaaa");
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
				String usr = rs.getString("pname");
				int age=rs.getInt("age");
				String disease=rs.getString("disease");
				Date date = rs.getDate("date_of_check");
				  pw.println("<html><body><h1>"+"name="+ usr +" "+"age="+age+" "+"disease="+disease+" "+"date_of_check="+date+" "+"</h1></body></html>");
				 // pw.println("<html><body><h1>enter details <a href='/Patientapp/patdetails.html'> here</a></h1></body></html>");
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

