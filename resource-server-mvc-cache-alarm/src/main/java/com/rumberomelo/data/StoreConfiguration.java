package com.rumberomelo.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class StoreConfiguration {

	@Bean(initMethod= "init")
	public Store getStore() {
		return new Store();
	}

}
