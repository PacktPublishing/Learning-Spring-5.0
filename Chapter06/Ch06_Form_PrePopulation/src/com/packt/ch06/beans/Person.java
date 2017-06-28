package com.packt.ch06.beans;

public class Person {

	private String firstName, lastName;
	private String hobby;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby=hobby;	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return firstName + "\t" + lastName + "\t" + hobby;
	}

}
