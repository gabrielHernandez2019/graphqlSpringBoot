package com.globallogic.graphql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterEntity {
	@Id
	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private String origin;
	private String location;
	private String image;
	private String episode;
	private String url;
	private String created;

}
