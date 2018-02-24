package com.webback.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webback.domain.Home;
import com.webback.persistence.mapper.HomePersistenceMapper;
import com.webback.persistence.model.HomePersistenceModel;

@Component
public class HomePersistenceHandler implements HomePersistence{

	private final HomePersistenceMapper homePersistenceMapper;
	
	@Autowired
	public HomePersistenceHandler(HomePersistenceMapper homePersistenceMapper) {
		this.homePersistenceMapper = homePersistenceMapper;
	}
	
	public Home getHome() {
		
		HomePersistenceModel homePersistenceModel = new HomePersistenceModel();
		
		homePersistenceModel.setMessage("Random information that would come from database.");
		
		return homePersistenceMapper.map(homePersistenceModel);
	}
}
