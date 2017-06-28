package com.ch02.scope.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.ch02.beans.Address;

@Component
@Scope(scopeName="prototype")
public class Customer_Scope {

	private String cust_name;
	private int cust_id;
	
	@Autowired  
	@Qualifier(value="address")
	private Address cust_address;

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public Address getCust_address() {
		return cust_address;
	}

	public void setCust_address(Address cust_address) {
		this.cust_address = cust_address;
	}

	public Customer_Scope() {
		// TODO Auto-generated constructor stub
		cust_id=10;
		cust_name="my name";
	}
}
