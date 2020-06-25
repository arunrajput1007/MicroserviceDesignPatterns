package com.sd.client.sdclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SdClientDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SdClientDemoApplication.class, args);
		PersonController controller = context.getBean(PersonController.class);
		controller.savePerson(new Person(0L,"Arun","Ahmedabad"));
	}

}
