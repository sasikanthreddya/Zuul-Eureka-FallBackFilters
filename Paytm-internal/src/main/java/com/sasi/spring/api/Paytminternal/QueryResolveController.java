package com.sasi.spring.api.Paytminternal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paytm/query")
public class QueryResolveController {
	
	@RequestMapping(value="/resloveTicket",method=RequestMethod.GET)
	public String get() {
		return "Ticket  resloved for this query ";
	}

}
