package com.globallogic.graphql.entity;

import java.util.Set;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterLocationEntity {
	/**
		 * 
		 */
	@EmbeddedId
	ChacarterLocationId id;
	
	@ManyToOne
	@MapsId("characterId")
	CharacterEntity characterEntity;
	
	@ManyToOne
	@MapsId("locationId")
	LocationEntity locationEntity;
	
	
}





