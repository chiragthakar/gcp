package com.banking.application.database;

public class User 
{
	private String name;
	private String number;
	private String userID;
	
	public User(String name, String number, String userID)
	{
		this.name = name;
		this.number = number;
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	

}
