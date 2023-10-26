package com.globallogic.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class GraphqlDemoApp {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApp.class, args);
	}
	
	


}
