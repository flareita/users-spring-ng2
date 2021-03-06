package it.flare.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import it.flare.Application;
import it.flare.ddd.domain.User;
import it.flare.ddd.dto.UserDTO;
import it.flare.ddd.facade.UserFacade;
import it.flare.ddd.facade.impl.UserFacadeImpl;

@Component
@Path("/api")
public class UserEndpoint {
	 static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);

	
	
	@Inject
	UserFacade userFacade;


	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {

		List<UserDTO> users = userFacade.getUsers();
		log.info("/users");

		return Response.status(200).entity(users).build();

	
	}

	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam(value = "id") Long id) {

		UserDTO user = userFacade.getUser(id);

		return Response.status(200).entity(user).build();

	}

	
	
	
	@GET
	@Path("/usernames/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserName(@PathParam(value = "name") String name) {

		List<UserDTO> users = userFacade.getUser(name==null?"":name);

		return Response.status(200).entity(users).build();

	}

	@PUT
	@Path("/users/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editUser(@PathParam(value = "id") String id, UserDTO payload) {

		UserDTO res=userFacade.editUser(payload);
		return Response.status(200).entity(res).build();

	}

	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(UserDTO payload) {

		UserDTO res=userFacade.editUser(payload);
		return Response.status(200).entity(res).build();

	}

																

	@DELETE
	@Path("/users/{id}")
	public Response deleteUser(@PathParam(value="id") Long id) {
		Long res=userFacade.deleteUser(id);
		return Response.status(200).entity(res).build();

	}
	
	
}
