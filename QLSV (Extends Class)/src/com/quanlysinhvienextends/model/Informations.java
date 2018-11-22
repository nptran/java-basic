package com.quanlysinhvienextends.model;

import java.time.LocalDate;

public class Informations {
	
	private String code;
	private String name;
	private LocalDate dob;
	private String group;

	

	protected LocalDate getDob() {
		return dob;
	}
	protected void setDob(LocalDate dob) {
		this.dob = dob;
	}
	protected String getCode() {
		return code;
	}
	protected void setCode(String code) {
		this.code = code;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getGroup() {
		return group;
	}
	protected void setGroup(String group) {
		this.group = group;
	}

	
}
