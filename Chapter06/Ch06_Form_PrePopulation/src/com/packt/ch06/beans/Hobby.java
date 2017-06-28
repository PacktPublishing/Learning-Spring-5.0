package com.packt.ch06.beans;

public class Hobby {
	private String hobbyName;
	private int hobbyId;
	public String getHobbyName() {
		return hobbyName;
	}
	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}
	public int getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}
	public Hobby() {
		// TODO Auto-generated constructor stub
	}
	
	public Hobby(String hobbyName,int hobbyId) {
		// TODO Auto-generated constructor stub
		this.hobbyName=hobbyName;
		this.hobbyId=hobbyId;
	}
	

}
