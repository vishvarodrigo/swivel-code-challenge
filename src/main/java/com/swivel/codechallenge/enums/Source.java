package com.swivel.codechallenge.enums;

public enum Source {
	USERS(1,"users.json"), TICKETS(2,"tickets.json"), ORGANIZATIONS(3,"organizations.json");

	private int value;
	private String fileName;

	private Source(int value,String fileName) {
		this.value = value;
		this.fileName = fileName;
	}

	public int getValue() {
		return this.value;
	}
	
	public String getFileName() {
		return this.fileName;
	}
}
