package com.globallogic.graphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.globallogic.graphql.entity.CharacterEntity;
import com.globallogic.graphql.record.CharacterInput;
import com.globallogic.graphql.record.ModelRecord;
import com.globallogic.graphql.service.RickyMortyService;

@Controller
public class GraphDemoController {

	private final RickyMortyService rickyMortyService;

	public GraphDemoController(RickyMortyService rickyMortyService) {
		this.rickyMortyService = rickyMortyService;
	}

	/**
	 * Cliente Rest Tradicional para obtener datos de una api GraphQl
	 * @return ModelRecord
	 */
	@PostMapping("/v1/apigraph/characters")
	public ResponseEntity<ModelRecord> getCharacters() {
		return ResponseEntity.ok().body(rickyMortyService.getCharacters());
	}

	
	/**
	 * Cliente Rest tradicional mezclado con query mapping para consultar una api GraphQl
	 * @return ModelRecord
	 */
	@QueryMapping 
	public ModelRecord getCharactersGraphQl() {
		return rickyMortyService.getCharacters();
	}
	
	/**
	 * Obtener datos de una base de datos para convertir mi api en un GraphQl
	 * @return List<CharacterEntity>
	 */
	@QueryMapping
	public List<CharacterEntity> characters() {
		return rickyMortyService.getCharactersGraphQl();

	}
	
	/**
	 * Mutation se utiliza para Crear Actualizar Eliminar
	 * @param characterInput
	 * @return
	 */
	@MutationMapping
	public CharacterEntity createCharacter(@Argument CharacterInput characterInput) {
		return rickyMortyService.saveCharacter(characterInput);
	}

}
