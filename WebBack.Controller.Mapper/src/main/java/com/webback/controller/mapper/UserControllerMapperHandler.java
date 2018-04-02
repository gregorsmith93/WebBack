package com.webback.controller.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.webback.controller.model.UserControllerModel;
import com.webback.domain.User;

@Component
public class UserControllerMapperHandler implements UserControllerMapper {

	private static final Logger LOG = LogManager.getLogger(UserControllerMapperHandler.class);

	@Override
	public User map(final UserControllerModel userControllerModel) {

		LOG.debug("Mapping UserControllerModel: {}", userControllerModel);

		final User user = new User();
		user.setName(userControllerModel.getName());
		user.setUsername(userControllerModel.getUsername());
		user.setPassword(userControllerModel.getPassword());
		user.setSalt(userControllerModel.getSalt());
		user.setUserId(userControllerModel.getUserId());

		LOG.debug("Mapped to User: {}", user);

		return user;
	}

	@Override
	public UserControllerModel map(final User user) {

		LOG.debug("Mapping User: {}", user);

		final UserControllerModel userControllerModel = new UserControllerModel();
		userControllerModel.setName(user.getName());
		userControllerModel.setUsername(user.getUsername());
		userControllerModel.setPassword(user.getPassword());
		userControllerModel.setSalt(user.getSalt());
		userControllerModel.setUserId(user.getUserId());

		LOG.debug("Mapped to UserControllerModel: {}", userControllerModel);

		return userControllerModel;
	}

}
