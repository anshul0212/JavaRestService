package com.learning.testProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.learning.testProject.util.ToJSON;

public class MySqlDBWrapper extends MySqlDB
{
	public Response getBrandDetails(String brand) throws Exception
	{
		
		PreparedStatement query = null;
		Response response = null;
		Connection conn = null;
		JSONArray json = new JSONArray();
		String returnString = null;
		
		try
		{
			conn = getMySqlConnection();
			query = conn.prepareStatement("select * from PC_Parts where PC_Parts_Maker = ?");
			query.setString(1, brand.toUpperCase());
			ResultSet rs = query.executeQuery();
			
			ToJSON toJson = new ToJSON();
			json = toJson.toJSONArray(rs);
			
			returnString = json.toString();
			query.close();
			response = Response.ok(returnString).build();		
		}
		catch(Exception e)
		{
			
		}
		return response;
		
	}
	
}
