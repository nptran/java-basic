package com.classroommanager.model;

public abstract class Room {
	
	private String code;
	private String block;
	private double area;
	private int lights;
	
	public String getCode() {
		return code.toUpperCase();
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBlock() {
		return block.toUpperCase();
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public int getLights() {
		return lights;
	}
	public void setLights(int lights) {
		this.lights = lights;
	}
	
}
