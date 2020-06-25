package com.client.config.configclientdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientDemoApplication.class, args);
	}

}

@RestController
class DummyController{

	@Value("${my.config}")
	private String value;

	@GetMapping
	public String checkApi(){
		return "got configuration: "+value;
	}
}
