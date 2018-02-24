package com.webback.persistence.mapper;

import org.springframework.stereotype.Component;

import com.webback.domain.Home;
import com.webback.persistence.model.HomePersistenceModel;

@Component
public class HomePersistenceMapperHandler implements HomePersistenceMapper {

	public Home map(HomePersistenceModel homePersistenceModel) {
		
		Home home = new Home();
		
		home.setMessage(homePersistenceModel.getMessage());
		
		return home;
	}
	
	public HomePersistenceModel map(Home home) {
		
		HomePersistenceModel homePersistenceModel = new HomePersistenceModel();
		
		homePersistenceModel.setMessage(home.getMessage());
		
		return homePersistenceModel;
	}
}
