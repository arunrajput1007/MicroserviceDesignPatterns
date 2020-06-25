package com.gateway.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayDemoApplication.class, args);
	}

	@Bean
	public RouteLocator routingLogic(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r1 -> r1.path("/person/**")
				.uri("lb://person-service/person/**"))
				.build();
	}
}
