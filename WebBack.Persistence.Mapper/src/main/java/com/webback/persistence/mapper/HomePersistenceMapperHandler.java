package com.webback.persistence.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.webback.domain.Home;
import com.webback.persistence.model.HomePersistenceModel;

@Component
public class HomePersistenceMapperHandler implements HomePersistenceMapper {

	private static final Logger LOG = LogManager.getLogger(HomePersistenceMapperHandler.class);

	@Override
	public Home map(final HomePersistenceModel homePersistenceModel) {

		LOG.debug("Mapping HomePersistenceModel: {}", homePersistenceModel);

		final Home home = new Home();

		home.setMessage(homePersistenceModel.getMessage());

		LOG.debug("Mapped to Home: {}", home);

		return home;
	}

	@Override
	public HomePersistenceModel map(final Home home) {

		LOG.debug("Mapping Home: {}", home);

		final HomePersistenceModel homePersistenceModel = new HomePersistenceModel();

		homePersistenceModel.setMessage(home.getMessage());

		LOG.debug("Mapped to HomePersistenceModel: {}", homePersistenceModel);

		return homePersistenceModel;
	}
}
