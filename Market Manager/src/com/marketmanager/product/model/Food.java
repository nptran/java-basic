package com.marketmanager.product.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Food extends Product{
	
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate exp;
	
	public LocalDate getExp() {
		return exp;
	}
	public void setExp(LocalDate exp) {
		this.exp = exp;
	}

}
