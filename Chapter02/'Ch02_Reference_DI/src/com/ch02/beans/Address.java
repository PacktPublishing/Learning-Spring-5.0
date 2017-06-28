package com.ch02.beans;

public class Address {
	private String city_name;
	private int build_no;
	private long pin_code;
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public void setBuild_no(int build_no) {
		this.build_no = build_no;
	}
	public void setPin_code(long pin_code) {
		this.pin_code = pin_code;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.city_name+"\t"+this.pin_code;
	}

}
