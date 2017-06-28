package com.packt.ch08.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String message()
	{
		return "welcome to method level security";
	}
	

}
