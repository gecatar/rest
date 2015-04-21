package com.sirma.itt.train;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserExceptionMapper implements ExceptionMapper<UserException>{

	@Override
	public Response toResponse(UserException userException) {
		return Response.status(Status.CONFLICT).entity(userException.getMessage()).build();
	}

}
