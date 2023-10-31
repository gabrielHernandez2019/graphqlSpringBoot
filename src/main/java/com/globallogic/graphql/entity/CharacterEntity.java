package com.globallogic.graphql.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String status;
	private String species;	
	private String type;
	private String gender;
	private String origin;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "characterEntity",fetch = FetchType.LAZY)
	private Set<CharacterLocationEntity> locations;
	private String image;
	private String episode;
	private String url;
	private String created;

}
