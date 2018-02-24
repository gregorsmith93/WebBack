package com.webback.service;

import org.springframework.stereotype.Service;

import com.webback.domain.Home;

@Service
public interface HomeService {

	Home getHomeMessage();
}
