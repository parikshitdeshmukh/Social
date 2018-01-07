package org.parik.restapi.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.parik.restapi.messenger.model.ErrorMessage;

@Provider
public class FieldEmptyExceptionMapper implements ExceptionMapper<FieldEmptyException>{

	@Override
	public Response toResponse(FieldEmptyException ex) {
		// TODO Auto-generated method stub
		ErrorMessage err = new ErrorMessage(ex.getMessage(), 406, "http://home.parikit.com");
		
		
		return Response.status(Status.NOT_ACCEPTABLE)
						.entity(err)
						.build();
	}
	
	
	

}
