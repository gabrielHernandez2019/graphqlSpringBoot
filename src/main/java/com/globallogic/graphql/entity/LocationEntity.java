package com.globallogic.graphql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class LocationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private String name;
	private String type; 
	private String dimension; 
	private String residents; 
	private String url;
	private String created;
	
	
}
