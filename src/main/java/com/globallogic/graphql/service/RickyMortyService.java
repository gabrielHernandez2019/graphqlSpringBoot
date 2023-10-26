package com.globallogic.graphql.service;

import java.util.List;

import com.globallogic.graphql.entity.CharacterEntity;
import com.globallogic.graphql.record.ModelRecord;

public interface RickyMortyService {

	ModelRecord getCharacters();
	
	List<CharacterEntity> getCharactersGraphQl();

}
