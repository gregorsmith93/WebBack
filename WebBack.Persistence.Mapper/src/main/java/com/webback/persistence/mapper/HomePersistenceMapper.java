package com.webback.persistence.mapper;

import org.springframework.stereotype.Component;

import com.webback.domain.Home;
import com.webback.persistence.model.HomePersistenceModel;

@Component
public interface HomePersistenceMapper {

	Home map(HomePersistenceModel homePersistenceModel);
	
	HomePersistenceModel map(Home home);
}
