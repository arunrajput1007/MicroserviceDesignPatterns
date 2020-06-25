package com.sd.demo.sddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SdDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdDemoApplication.class, args);
	}
}
