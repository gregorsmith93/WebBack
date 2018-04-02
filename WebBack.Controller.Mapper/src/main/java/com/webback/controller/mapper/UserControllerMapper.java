package com.webback.controller.mapper;

import org.springframework.stereotype.Component;

import com.webback.controller.model.UserControllerModel;
import com.webback.domain.User;

@Component
public interface UserControllerMapper {

	User map(UserControllerModel userControllerModel);

	UserControllerModel map(User user);
}
