package com.webback.persistence.service;

import org.springframework.stereotype.Component;

import com.webback.domain.User;

@Component
public interface UserPersistenceService {

	User createUser(User user);

	User readUserByUsername(User user);

	Long deleteUserByUsername(User user);
}
