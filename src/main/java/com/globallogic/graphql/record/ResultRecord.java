package com.globallogic.graphql.record;

import java.net.URL;
import java.util.List;

public record ResultRecord(Integer id, 
		String name, 
		String status, 
		String species, 
		String type, 
		String gender,
		LocationRecord origin,
		LocationRecord location,
		URL image,
		List<String> episode,
		String url,
		String created) {

}
