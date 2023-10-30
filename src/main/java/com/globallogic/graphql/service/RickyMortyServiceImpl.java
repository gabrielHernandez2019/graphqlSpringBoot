package com.globallogic.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.graphql.client.RickyMortyClient;
import com.globallogic.graphql.entity.CharacterEntity;
import com.globallogic.graphql.record.CharacterInput;
import com.globallogic.graphql.record.ModelRecord;
import com.globallogic.graphql.record.ResultRecord;
import com.globallogic.graphql.repository.RickyMortyRepository;

import graphql.GraphQLException;

@Service
public class RickyMortyServiceImpl implements RickyMortyService {
	

	private RickyMortyClient rickyMortyClient;
	
	private RickyMortyRepository repository;
	
	@Autowired
	public RickyMortyServiceImpl(RickyMortyClient rickyMortyClient, RickyMortyRepository repository){
		this.rickyMortyClient = rickyMortyClient;
		this.repository = repository;
	}
	
	
	public ModelRecord getCharacters() {
		ModelRecord model = rickyMortyClient.getcharacters();
		List<ResultRecord> character =  model.data().characters().results();
		List<CharacterEntity> entitySaves = new ArrayList<CharacterEntity>();
		repository.deleteAll();
		for (ResultRecord resultRecord : character) {
			 
			entitySaves.add(CharacterEntity.builder()
					.id(resultRecord.id())
					.created(resultRecord.created())
					.name(resultRecord.name())
					.gender(resultRecord.gender())
					.status(resultRecord.status())
					.build());
		}
		repository.saveAll(entitySaves);
		
		return model; 
	}
	
	public List<CharacterEntity> getCharactersGraphQl() {
		return repository.findAll();
	}
	
	public CharacterEntity saveCharacter(CharacterInput input) {
		CharacterEntity entity =  new CharacterEntity();
		entity.setName(input.name());
		if (input.name().equalsIgnoreCase("exception")) {
			throw new GraphQLException("recurso no accesible");
		}
		return repository.save(entity);
	}
	

}
