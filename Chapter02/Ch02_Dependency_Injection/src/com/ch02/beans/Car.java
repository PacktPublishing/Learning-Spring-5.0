package com.ch02.beans;

public class Car {
	private String chassis_number, color, fuel_type;
	public String getChassis_number() {
		return chassis_number;
	}

	public void setChassis_number(String chassis_number) {
		this.chassis_number = chassis_number;
	}


	private long price;
	private double average;

	
	public void setColor(String color) {
		this.color = color;
	}

	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public void show() {
		System.out.println("showing car " + chassis_number + " having color:-"
				+ color + " and price:-" + price);
	}

	public Car(String chassis_number,String color,double average, long price, String fuel_type) {
		// TODO Auto-generated constructor stub
		this.chassis_number = chassis_number;
		this.average = average;
		this.price = price;
		this.color=color;
		this.fuel_type=fuel_type;
	}


	 public Car() {
			// TODO Auto-generated constructor stub
		 chassis_number="eng00";
	    	color="white";
	    	fuel_type="diesel";
	    	price=570000l;
	    	average=12d;
		}
}
