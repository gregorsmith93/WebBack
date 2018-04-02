package com.webback.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webback.controller.mapper.HomeControllerMapper;
import com.webback.controller.model.HomeControllerModel;
import com.webback.domain.Home;
import com.webback.service.HomeService;

@Path(ControllerConstants.HOME_PATH)
@Component
public class HomeController {

	private static final Logger LOG = LogManager
			.getLogger(HomeController.class);

	private final HomeService homeService;

	private final HomeControllerMapper homeControllerMapper;

	private final JsonUtilities jsonUtilities;

	@Autowired
	public HomeController(final HomeService homeService,
			final HomeControllerMapper homeControllerMapper,
			final JsonUtilities jsonUtilities) {
		this.homeService = homeService;
		this.homeControllerMapper = homeControllerMapper;
		this.jsonUtilities = jsonUtilities;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHomePage() {

		LOG.debug("Starting to get home page from back end service.");

		final Home home = homeService.getHomeMessage();

		final HomeControllerModel homeControllerModel = homeControllerMapper
				.map(home);

		final String jsonString = jsonUtilities
				.convertToJsonString(homeControllerModel);

		LOG.debug("Finished getting home page from back end service.");

		return Response.status(200).entity(jsonString).build();
	}
}
