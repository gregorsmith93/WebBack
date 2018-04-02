package com.webback.persistence.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.webback.domain.Home;
import com.webback.persistence.mapper.HomePersistenceMapper;
import com.webback.persistence.model.HomePersistenceModel;
import com.webback.persistence.repository.HomeRepository;

@Component
@Transactional
public class HomePersistenceHandler implements HomePersistence {

	private static final Logger LOG = LogManager.getLogger(HomePersistenceHandler.class);

	private final HomePersistenceMapper homePersistenceMapper;

	private final HomeRepository homeRepository;

	@Autowired
	public HomePersistenceHandler(
			final HomePersistenceMapper homePersistenceMapper,
			final HomeRepository homeRepository) {
		this.homePersistenceMapper = homePersistenceMapper;
		this.homeRepository = homeRepository;
	}

	@Override
	public Home getHome() {

		LOG.debug("Retrieving home message from database.");

		final List<HomePersistenceModel> homePersistenceModelList = homeRepository
				.findAll();

		LOG.debug("Retrieved home message list: {}", homePersistenceModelList);

		return homePersistenceMapper.map(homePersistenceModelList.get(0));
	}
}
