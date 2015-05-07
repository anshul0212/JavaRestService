package com.learning.testProject.inventory;

import javax.ws.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import java.sql.*;

import com.learning.testProject.dao.*;
import com.learning.testProject.util.ToJSON;

@Path("/v1/inventory")
public class V1_Inventory {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInventory() throws Exception
	{
		PreparedStatement query = null;
		Connection conn = null;
		JSONArray json = new JSONArray();
		String returnString = null;
		Response response = null;
		try
		{
			
			returnString = json.toString();
			query.close();
			response = Response.ok(returnString).build();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
				conn.close();		
		}
		return response;
	}

}
