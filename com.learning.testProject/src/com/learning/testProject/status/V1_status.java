package com.learning.testProject.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;

import com.learning.testProject.dao.*;

@Path("/v1/status")
public class V1_status {
	
	private static final String api_version = "00.1";
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle()
	{
		return "<p>Java WS</p>";
	}

	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion()
	{
		return "<p>Version: "+api_version+"</p>";
	}
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getDatabaseStatus() throws Exception
	{
		PreparedStatement query = null;
		String name = null, empNo = null,
     		   returnString = null;
		Connection conn = null;
		
		try
		{
			conn = MySqlDB.getMySqlDBCon().getConnection();
			query = conn.prepareStatement("select Name, EmpNo from myFirstTestTable");
			ResultSet rs = query.executeQuery();
			
			while(rs.next())
			{
				name = rs.getString("Name");
				empNo = rs.getString("EmpNo");
			}
			
			query.close();
			returnString = "<p>myFirstTest Table:</p>" +
							"<p>Name :"+ name +"</p>" +
							"<p>Emp No. :"+ empNo +"</p>";
			
		}
		catch(Exception e)
		{
			returnString = "<p>Exception generated while connecting to database.</p>";
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			conn.close();
		}
		return returnString;
	}
}
