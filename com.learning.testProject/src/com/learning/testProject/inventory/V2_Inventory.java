package com.learning.testProject.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.learning.testProject.dao.MySqlDB;
import com.learning.testProject.dao.MySqlDBWrapper;
import com.learning.testProject.util.ToJSON;

@Path("/v2/inventory")
public class V2_Inventory {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInventory( @QueryParam("brand") String brand) throws Exception
	{
		Response response = null;
		MySqlDBWrapper mySqlDB = new MySqlDBWrapper();
		response = mySqlDB.getBrandDetails(brand);
		
		return response;
	}
}
