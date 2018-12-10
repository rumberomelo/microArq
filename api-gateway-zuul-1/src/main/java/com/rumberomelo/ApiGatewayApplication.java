package com.rumberomelo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApiGatewayApplication {
	
	org.springframework.security.web.authentication.HttpStatusEntryPoint a;
	org.springframework.security.config.annotation.web.builders.HttpSecurity b;

    public static void main(String[] args) {
    	 SpringApplication app =
                 new SpringApplication(ApiGatewayApplication.class);
		
		
		
		Properties properties = new Properties();
        properties.setProperty("spring.resources.static-locations",
                          "classpath:/templates/");
        app.setDefaultProperties(properties);
        app.run(args);
        
    }
    
    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*");
			}
		};
	}

}
