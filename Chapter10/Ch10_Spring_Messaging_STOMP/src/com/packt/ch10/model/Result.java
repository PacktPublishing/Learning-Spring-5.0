package com.packt.ch10.model;

public class Result {

	private String result;

	public Result(String result) {
		this.result = result;
	}

	public Result() {
		// TODO Auto-generated constructor stub
		result="NO OFFERS!!!!";
	}
	public String getResult() {
		return result;
	}

	public void getOffer(String bookName) {
		if (bookName.equals("Spring 5.0")) {
			result = bookName + " is having offer of having 20% off";
		} else if (bookName.equals("Core JAVA")) {
			result = bookName + " Buy two books and get 10% off";

		} else if (bookName.equals("Spring 4.0")) {
			result = bookName + " is having for 1000 till month end";
		}

		else
			result = bookName + " is not available on the list";
	}

}
