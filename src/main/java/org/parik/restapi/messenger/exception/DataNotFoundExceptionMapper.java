package org.parik.restapi.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.parik.restapi.messenger.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage err= new ErrorMessage(ex.getMessage(), 404, "http://home.parikit.com/");
		
		
		return Response.status(Status.NOT_FOUND)
						.entity(err)
						.build();
	}
		

}
