package com.webback.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webback.persistence.model.HomePersistenceModel;

@Transactional
@Repository
public interface HomeRepository
		extends JpaRepository<HomePersistenceModel, Long> {
}
