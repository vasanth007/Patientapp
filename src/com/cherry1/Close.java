package com.cherry1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Close 
{
 public static void CloseCon(Connection con, PreparedStatement ps) throws SQLException
 {
	 ps.close();
	 con.close();
 }
}
