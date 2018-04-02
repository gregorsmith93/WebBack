package com.webback.controller.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.webback.controller.model.HomeControllerModel;
import com.webback.domain.Home;

@Component
public class HomeControllerMapperHandler implements HomeControllerMapper {

	private static final Logger LOG = LogManager.getLogger(HomeControllerMapperHandler.class);

	@Override
	public HomeControllerModel map(final Home home) {

		LOG.debug("Mapping Home: {}", home);

		final HomeControllerModel homeControllerModel = new HomeControllerModel();

		homeControllerModel.setMessage(home.getMessage());

		LOG.debug("Mapped to HomeControllerModel: {}", homeControllerModel);

		return homeControllerModel;
	}

	@Override
	public Home map(final HomeControllerModel homeControllerModel) {

		LOG.debug("Mapping HomeControllerModel: {}", homeControllerModel);

		final Home home = new Home();

		home.setMessage(homeControllerModel.getMessage());

		LOG.debug("Mapped to Home: {}", home);

		return home;
	}
}
