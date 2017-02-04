package it.flare.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import it.flare.ddd.exception.AppException;

@Provider
public class AppExceptionMapper implements
        ExceptionMapper<AppException> {
    @Override
    public Response toResponse(AppException ex) {
        //whatever
    	int code=404;
    	return Response.status(code).entity(ex.getMessage()).type("text/plain")
                .build();
    }
}