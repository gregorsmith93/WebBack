package com.webback.persistence.mapper;

import org.springframework.stereotype.Component;

import com.webback.domain.User;
import com.webback.persistence.model.UserPersistenceModel;

@Component
public interface UserPersistenceMapper {

	User map(UserPersistenceModel userPersistenceModel);

	UserPersistenceModel map(User user);
}
