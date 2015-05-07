package com.learning.testProject.inventory;

import javax.ws.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;

import java.sql.*;

import com.learning.testProject.dao.*;
import com.learning.testProject.util.ToJSON;

@Path("/v1/inventory")
public class V1_Inventory {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getInventory() throws Exception
	{
		PreparedStatement query = null;
		Connection conn = null;
		JSONArray json = new JSONArray();
		String returnString = null;
		
		try
		{
			conn = MySqlDB.getMySqlDBCon().getConnection();
			query = conn.prepareStatement("select * from PC_Parts");
			
			ResultSet rs = query.executeQuery();
			
			ToJSON toJson = new ToJSON();
			json = toJson.toJSONArray(rs);
			returnString = json.toString();
			query.close();
			
		}
		catch(Exception e)
		{
			returnString = "[{Exception:catch}]";
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
