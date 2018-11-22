package com.management.model;

public class Customer {
	
	public static int code = 1000;
	String name;
	String address;
	long phoneNumber;
	
	public int getCode() {
		return code;
	}
	public void setCode() {
		Customer.code++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
