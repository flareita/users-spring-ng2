package it.flare.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import it.flare.rest.AppExceptionMapper;
import it.flare.rest.UserEndpoint;

@Configuration
@ApplicationPath("/demo")
	public class JerseyConfig extends ResourceConfig {
	    public JerseyConfig() {
	        register(UserEndpoint.class)
	        .register(AppExceptionMapper.class);
	    }
}
