package com.webback.controller.mapper;

import org.springframework.stereotype.Component;

import com.webback.controller.model.HomeControllerModel;
import com.webback.domain.Home;

@Component
public interface HomeControllerMapper {

	HomeControllerModel map(Home home);

	Home map(HomeControllerModel homeControllerModel);
}
