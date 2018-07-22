package com.sasi.spring.api.Paytmclient.config;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfig {
	
	@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}

}
