package com.management.model;

public class Item {
	
	public static int code = 10000;
	String name;
	String group;
	double cost;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		Item.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

}
