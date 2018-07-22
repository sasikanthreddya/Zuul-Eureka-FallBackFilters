package com.sasi.spring.api.Paytmclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/paytm/users")
public class UsersController {

	
	  @Autowired
	    private RestTemplate restTemplate;
	  
	  @HystrixCommand(fallbackMethod = "UserServiceFaliled", groupKey = "paytm",
	            commandKey = "paytm",
	            threadPoolKey = "Threadpool"
	            )
	   @GetMapping
	    public String GetUserInfo() {
	        String url = "http://user-service/Users/get";
	        return restTemplate.getForObject(url, String.class);
	    }
	  public String UserServiceFaliled(Throwable hystrixCommand) {
	        return "user service failed";
	    }
}
