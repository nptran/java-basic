package com.quanlysinhvienextends.model;

import java.time.LocalDate;

public class Student extends Informations {

	private double avgscore;
	
	public double getAvgscore() {
		return avgscore;
	}

	public void setAvgscore(double avgscore) {
		this.avgscore = avgscore;
	}
	

	@Override
	public LocalDate getDob() {
		return super.getDob();
	}

	@Override
	public String getCode() {
		return super.getCode();
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public String getGroup() {
		return super.getGroup();
	}

	@Override
	public void setCode(String code) {
		super.setCode(code);
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public void setGroup(String group) {
		super.setGroup(group);
	}

	@Override
	public void setDob(LocalDate dob) {
		super.setDob(dob);
	}

}
