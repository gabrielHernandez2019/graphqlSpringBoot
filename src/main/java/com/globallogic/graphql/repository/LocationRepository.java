package com.globallogic.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.graphql.entity.CharacterEntity;

@Repository
public interface LocationRepository extends JpaRepository<CharacterEntity,Integer> {
	
	
}
