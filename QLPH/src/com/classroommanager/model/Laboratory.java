package com.classroommanager.model;

public class Laboratory extends Room {

	private String major;
	private int capacity;
	private boolean bath;
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getBath() {
		if(bath == true)
			return "Có";
		else return "Không";
	}
	public void setBath(boolean bath) {
		this.bath = bath;
	}
	
}
