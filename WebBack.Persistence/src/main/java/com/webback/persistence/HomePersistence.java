package com.webback.persistence;

import org.springframework.stereotype.Component;

import com.webback.domain.Home;

@Component
public interface HomePersistence {

	Home getHome();
}
