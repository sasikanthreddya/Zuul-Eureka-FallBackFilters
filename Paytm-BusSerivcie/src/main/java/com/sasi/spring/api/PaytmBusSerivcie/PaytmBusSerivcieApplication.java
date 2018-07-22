package com.sasi.spring.api.PaytmBusSerivcie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaytmBusSerivcieApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaytmBusSerivcieApplication.class, args);
	}
}
