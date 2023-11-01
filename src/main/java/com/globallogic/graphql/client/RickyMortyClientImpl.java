package com.globallogic.graphql.client;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.globallogic.graphql.record.ModelRecord;
import com.globallogic.graphql.record.QueryRequestRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RickyMortyClientImpl implements RickyMortyClient {

	private final WebClient webCliente;

	private HttpGraphQlClient graphCliente;

	@Autowired
	public RickyMortyClientImpl(WebClient.Builder webClientBuilder, @Value("${ricky.morty.graph.url}") String url) {
		this.webCliente = webClientBuilder.baseUrl(url).build();

	}

	@Override
	public ModelRecord getcharacters() {
		// pasar el grapho como si estuvieramos en el cliente nativo

		String query = "query { characters{results{id name image gender location {id name }}}}";

		ModelRecord data = webCliente.post()
				.bodyValue(new QueryRequestRecord(query, null))
				.retrieve()
				.bodyToMono(ModelRecord.class)
				.block();

		log.info("data from webClient------> {}", data.toString());
		
		graphCliente = HttpGraphQlClient.builder(webCliente).build();
		ClientGraphQlResponse resp = graphCliente
				.document(query)
				.execute()
				.block();

		LinkedHashMap<String, Object> dt = resp.getData();
		log.info("data from graphClient------> {}", dt.toString());
		return data;
	}

}
