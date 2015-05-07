package com.learning.testProject.dao;

import java.sql.Connection;

import javax.naming.*;
import javax.sql.*;

public class MySqlDB {

	private static DataSource mySqlDataSource = null;
	private static Context context = null;
	
	public static DataSource getMySqlDBCon() throws Exception 
	{
		if( mySqlDataSource != null)
		{
			return mySqlDataSource;
		}
		try
		{
			if(context == null)
			{
				context = new InitialContext();
			}
			
				mySqlDataSource = (DataSource) context.lookup("jdbc/mysql_ds");
			
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		return mySqlDataSource;
	}
	
	protected static Connection getMySqlConnection() throws Exception
	{
		Connection conn = null;
		conn = MySqlDB.getMySqlDBCon().getConnection();
		return conn;
	}
}
