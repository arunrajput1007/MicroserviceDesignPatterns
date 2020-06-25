package com.sd.client.sdconsumerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SdConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdConsumerDemoApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}

@RestController
class ConsumerService{

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("{id}")
	public String getName(@PathVariable Long id){
		return restTemplate.getForObject("http://person-service/person/"+id,String.class);
	}


}
