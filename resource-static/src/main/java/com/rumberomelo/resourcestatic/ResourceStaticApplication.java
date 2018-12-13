package com.rumberomelo.resourcestatic;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResourceStaticApplication {

	public static void main(String[] args) {
		
		 SpringApplication app =
                 new SpringApplication(ResourceStaticApplication.class);
		
		
		
		Properties properties = new Properties();
        properties.setProperty("spring.resources.static-locations",
                          "classpath:/templates/");
        app.setDefaultProperties(properties);
        app.run(args);
		
	}
}
