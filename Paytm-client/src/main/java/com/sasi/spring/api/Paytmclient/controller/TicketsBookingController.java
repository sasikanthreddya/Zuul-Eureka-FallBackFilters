package com.sasi.spring.api.Paytmclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/paytm/ticket")
public class TicketsBookingController {
	
	  @Autowired
	    private RestTemplate restTemplate;
	  
	 
	
	  @HystrixCommand(fallbackMethod = "bookingFailed", groupKey = "paytm",
	            commandKey = "paytm",
	            threadPoolKey = "Threadpool"
	            )
	  @GetMapping
	    public String TicketsBooking() {
	        String url = "http://paytm-bus-service//paytm/bus/server";
	        return restTemplate.getForObject(url, String.class)+ " congts";
	    }
	  
	  public String bookingFailed(Throwable hystrixCommand) {
	        return "unable to book the ticket due to some issue with bus operator";
	    }

	 
}