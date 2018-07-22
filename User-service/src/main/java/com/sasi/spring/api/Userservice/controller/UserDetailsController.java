package com.sasi.spring.api.Userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Users")
public class UserDetailsController {
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String get() {
		return " Hello user";
	}

}
