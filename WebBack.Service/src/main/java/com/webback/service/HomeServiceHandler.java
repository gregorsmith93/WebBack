package com.webback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webback.domain.Home;
import com.webback.persistence.HomePersistence;

@Service
public class HomeServiceHandler implements HomeService {

	private final HomePersistence homePersistence;
	
	@Autowired
	public HomeServiceHandler(HomePersistence homePersistence) {
		this.homePersistence = homePersistence;
	}
	
	public Home getHomeMessage() {
		return homePersistence.getHome();
	}
}
