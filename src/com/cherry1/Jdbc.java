package com.cherry1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Jdbc 
{
	public static Connection connect() throws ClassNotFoundException, SQLException
	{
		Connection con;
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("jdbc code starts");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
		System.out.println("connected");
		    ResultSet rs;
	
return con;
}
}
