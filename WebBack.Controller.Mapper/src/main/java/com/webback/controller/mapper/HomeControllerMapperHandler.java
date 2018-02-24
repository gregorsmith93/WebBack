package com.webback.controller.mapper;

import org.springframework.stereotype.Component;

import com.webback.controller.model.HomeControllerModel;
import com.webback.domain.Home;

@Component
public class HomeControllerMapperHandler implements HomeControllerMapper{

	public HomeControllerModel map(Home home) {
		
		HomeControllerModel homeControllerModel = new HomeControllerModel();
		
		homeControllerModel.setMessage(home.getMessage());
		
		return homeControllerModel;
	}
	
	public Home map(HomeControllerModel homeControllerModel) {
		
		Home home = new Home();
		
		home.setMessage(homeControllerModel.getMessage());
		
		return home;
	}
}
