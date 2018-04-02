package com.webback.service;

import org.springframework.stereotype.Service;

import com.webback.domain.User;

@Service
public interface UserService {

	User createUser(User user);

	User readUser(User user);

	User login(User user);
}
