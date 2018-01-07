package org.parik.restapi.messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/{demo}")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class DemoParams {
	
	
	@GET
	public String demoParamAccess(@HeaderParam("HeaderLabel") String header,
								@QueryParam("queryparam") String queryParam,
								@MatrixParam("matrixparam") String matrixParam,
								@CookieParam("JSESSIONID") String cookieParam) {
		
		return "Header Param: " + header + " " + "QueryParam: " + queryParam + " " + "MatrixParam: "+  matrixParam + " " +  "CookieParam: " +cookieParam ;
	}
	
	

}
