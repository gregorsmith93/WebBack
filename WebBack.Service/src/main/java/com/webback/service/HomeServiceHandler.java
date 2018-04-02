package com.webback.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webback.domain.Home;
import com.webback.persistence.service.HomePersistence;

@Service
public class HomeServiceHandler implements HomeService {

	private static final Logger LOG = LogManager.getLogger(HomeServiceHandler.class);

	private final HomePersistence homePersistence;

	@Autowired
	public HomeServiceHandler(final HomePersistence homePersistence) {
		this.homePersistence = homePersistence;
	}

	@Override
	public Home getHomeMessage() {

		LOG.debug("Getting home message.");

		final Home home = homePersistence.getHome();

		LOG.debug("Got home message: {}", home);

		return home;
	}
}
