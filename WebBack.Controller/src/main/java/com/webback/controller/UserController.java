package com.webback.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import com.webback.controller.mapper.UserControllerMapper;
import com.webback.controller.model.UserControllerModel;
import com.webback.domain.User;
import com.webback.service.UserService;

@Path(ControllerConstants.USER_PATH)
@Controller
public class UserController {

	private static final Logger LOG = LogManager.getLogger(UserController.class);

	private final UserService userService;

	private final UserControllerMapper userControllerMapper;

	private final JsonUtilities jsonUtilities;

	@Autowired
	public UserController(final UserService userService,
			final UserControllerMapper userControllerMapper,
			final JsonUtilities jsonUtilities) {
		this.userService = userService;
		this.userControllerMapper = userControllerMapper;
		this.jsonUtilities = jsonUtilities;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response createUser(final UserControllerModel userControllerModel) {

		LOG.debug("Received create user request: {}", userControllerModel);

		final User user = userControllerMapper.map(userControllerModel);

		final User createdUser = userService.createUser(user);

		final UserControllerModel createdUserControllerModel = userControllerMapper
				.map(createdUser);

		final String jsonString = jsonUtilities
				.convertToJsonString(createdUserControllerModel);

		LOG.debug("Returning response with status 200, and body: {}", jsonString);

		return Response.ok().entity(jsonString).build();
	}

	@GET
	@Path(ControllerConstants.READ_PATH)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response readUserByUsername(
			@QueryParam(value = "username") final String username) {

		LOG.debug("Received read user by username request: {}", username);

		final User user = new User();
		user.setUsername(username);

		final User userResult = userService.readUser(user);

		final UserControllerModel createdUserControllerModel = userControllerMapper
				.map(userResult);

		final String jsonString = jsonUtilities
				.convertToJsonString(createdUserControllerModel);

		LOG.debug("Returning response with status 200, and body: {}", jsonString);

		return Response.ok().entity(jsonString).build();
	}

	@POST
	@Path(ControllerConstants.LOGIN_PATH)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response login(final UserControllerModel userControllerModel) {

		LOG.debug("Received login request: {}", userControllerModel);

		final User user = userControllerMapper.map(userControllerModel);

		final User createdUser = userService.login(user);

		final UserControllerModel createdUserControllerModel = userControllerMapper
				.map(createdUser);

		final String jsonString = jsonUtilities
				.convertToJsonString(createdUserControllerModel);

		LOG.debug("Returning response with status 200, and body: {}", jsonString);

		return Response.ok().entity(jsonString).build();
	}
}
