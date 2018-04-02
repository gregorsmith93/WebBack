package com.webback.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webback.domain.User;
import com.webback.persistence.service.UserPersistenceService;

@Service
public class UserServiceHandler implements UserService {

	private static final Logger LOG = LogManager.getLogger(UserServiceHandler.class);

	private final UserPersistenceService userPersistenceService;

	@Autowired
	public UserServiceHandler(
			final UserPersistenceService userPersistenceService) {
		this.userPersistenceService = userPersistenceService;
	}

	@Override
	public User createUser(final User user) {

		LOG.debug("Creating user: {}", user);

		final User createdUser = userPersistenceService.createUser(user);

		LOG.debug("Created user: {}", createdUser);

		return createdUser;
	}

	@Override
	public User readUser(final User user) {

		LOG.debug("Retrieving user: {}", user.getUsername());

		final User retrievedUser = userPersistenceService.readUserByUsername(user);

		LOG.debug("Retrieved user: {}", retrievedUser);

		return retrievedUser;
	}

	@Override
	public User login(final User user) {

		LOG.debug("Performing login request for user: {}", user);

		final User databaseUser = userPersistenceService
				.readUserByUsername(user);

		final boolean passwordResult = user.getPassword()
				.equals(databaseUser.getPassword());

		User loginResult = null;

		if (passwordResult) {

			LOG.debug("Valid password supplied for user: {}", user.getUsername());
			loginResult = databaseUser;
		} else {
			LOG.warn("Invaid password supplied for user: {}", user.getUsername());
			throw new SecurityException("Invalid password.");
		}

		return loginResult;
	}
}
