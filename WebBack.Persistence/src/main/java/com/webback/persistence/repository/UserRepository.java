package com.webback.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webback.persistence.model.UserPersistenceModel;

@Transactional
@Repository
public interface UserRepository
		extends JpaRepository<UserPersistenceModel, Long> {

	UserPersistenceModel findByUsername(String username);

	Long deleteByUsername(String username);
}
