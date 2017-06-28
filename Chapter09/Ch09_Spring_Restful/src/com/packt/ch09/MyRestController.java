package com.packt.ch09;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String getData()
	{
		return("welcome to web services");
	}

}
