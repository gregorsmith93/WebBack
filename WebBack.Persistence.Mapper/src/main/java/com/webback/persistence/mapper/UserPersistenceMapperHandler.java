package com.webback.persistence.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.webback.domain.User;
import com.webback.persistence.model.UserPersistenceModel;

@Component
public class UserPersistenceMapperHandler implements UserPersistenceMapper {

	private static final Logger LOG = LogManager.getLogger(UserPersistenceMapperHandler.class);

	@Override
	public User map(final UserPersistenceModel userPersistenceModel) {

		LOG.debug("Mapping UserPersistenceModel: {}", userPersistenceModel);

		final User user = new User();
		user.setName(userPersistenceModel.getName());
		user.setUsername(userPersistenceModel.getUsername());
		user.setPassword(userPersistenceModel.getPassword());
		user.setSalt(userPersistenceModel.getSalt());
		user.setUserId(userPersistenceModel.getUserId());

		LOG.debug("Mapped to User: {}", user);

		return user;
	}

	@Override
	public UserPersistenceModel map(final User user) {

		LOG.debug("Mapping User: {}", user);

		final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
		userPersistenceModel.setName(user.getName());
		userPersistenceModel.setUsername(user.getUsername());
		userPersistenceModel.setPassword(user.getPassword());
		userPersistenceModel.setSalt(user.getSalt());
		userPersistenceModel.setUserId(user.getUserId());

		LOG.debug("Mapped to UserPersistenceModel: {}", userPersistenceModel);

		return userPersistenceModel;
	}

}
