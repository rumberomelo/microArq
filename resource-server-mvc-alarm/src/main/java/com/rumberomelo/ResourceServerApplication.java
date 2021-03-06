package com.rumberomelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableFeignClients
class ResourceServerApplication {

	org.springframework.boot.bind.InetAddressEditor a;
	
    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class, args);
    }

}
