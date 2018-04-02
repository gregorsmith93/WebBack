package com.webback.persistence.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.webback.domain.User;
import com.webback.persistence.mapper.UserPersistenceMapper;
import com.webback.persistence.model.UserPersistenceModel;
import com.webback.persistence.repository.UserRepository;

@Component
@Transactional
public class UserPersistenceServiceHandler implements UserPersistenceService {

	private static final Logger LOG = LogManager.getLogger(UserPersistenceServiceHandler.class);

	private final UserPersistenceMapper userPersistenceMapper;

	private final UserRepository userRepository;

	@Autowired
	public UserPersistenceServiceHandler(
			final UserPersistenceMapper userPersistenceMapper,
			final UserRepository userRepository) {
		this.userPersistenceMapper = userPersistenceMapper;
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(final User user) {

		LOG.debug("Adding user to database: {}", user);

		final UserPersistenceModel userPersistenceModel = userPersistenceMapper
				.map(user);

		final UserPersistenceModel createdUser = userRepository
				.save(userPersistenceModel);

		LOG.debug("User added to database: {}", createdUser);

		return userPersistenceMapper.map(createdUser);
	}

	@Override
	public User readUserByUsername(final User user) {

		LOG.debug("Reading user from database by username: {}", user.getUsername());

		final UserPersistenceModel userPersistenceModel = userPersistenceMapper
				.map(user);

		final UserPersistenceModel userResult = userRepository
				.findByUsername(userPersistenceModel.getUsername());

		LOG.debug("Read user from database returned user: {}", userResult);

		return userPersistenceMapper.map(userResult);
	}

	@Override
	public Long deleteUserByUsername(final User user) {

		final UserPersistenceModel userPersistenceModel = userPersistenceMapper
				.map(user);

		final Long userResult = userRepository
				.deleteByUsername(userPersistenceModel.getUsername());

		return userResult;
	}
}
