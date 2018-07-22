package com.sasi.spring.api.PaytmBusSerivcie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paytm/bus/server")
public class BookingTicketController {

	
	 @GetMapping
	    public String Ticket() {
	        return "Hello  your ticket confirmed !";
	    }
}
