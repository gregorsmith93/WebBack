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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webback.controller.mapper.HomeControllerMapper;
import com.webback.controller.model.HomeControllerModel;
import com.webback.domain.Home;
import com.webback.service.HomeService;

@Path(ControllerConstants.HOME_PATH)
@Component
public class HomeController {

	private static final Logger LOG = LogManager.getLogger(HomeController.class);
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private final HomeService homeService;
	
	private final HomeControllerMapper homeControllerMapper;
	
	@Autowired
	public HomeController(HomeService homeService, HomeControllerMapper homeControllerMapper) {
		this.homeService = homeService;
		this.homeControllerMapper = homeControllerMapper;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHomePage() {
		
		LOG.debug("Starting to get home page from back end service.");
		
		Home home = homeService.getHomeMessage();
		
		HomeControllerModel homeControllerModel = homeControllerMapper.map(home);
		
		String jsonString;
		
		try {
		    jsonString = mapper.writeValueAsString(homeControllerModel);
		}
		catch (JsonProcessingException e) {
			jsonString = "";
		}
		
		LOG.debug("Finished getting home page from back end service.");
		
		return Response.status(200).entity(jsonString).build();
	}
}
