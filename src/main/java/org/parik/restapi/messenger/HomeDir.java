package org.parik.restapi.messenger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;

@Path("/home")
public class HomeDir {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHome() {
		
		return "Welcome to a Site incorporating REST API!";
		
	}
	
	

}
