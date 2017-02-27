package it.flare.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import it.flare.Application;
import it.flare.ddd.exception.AppException;

@Provider
public class AppExceptionMapper implements
        ExceptionMapper<AppException> {
	 static final Logger log = LoggerFactory.getLogger(AppExceptionMapper.class);
	
	@Override
    public Response toResponse(AppException ex) {
        //whatever
		log.info("exception caught "+ex);
		
    	int code=404;
    	return Response.status(code).entity(ex.getMessage()).type("text/plain")
                .build();
    }
}