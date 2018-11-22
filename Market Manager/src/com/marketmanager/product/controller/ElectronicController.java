package com.marketmanager.product.controller;

import java.util.ArrayList;
import java.util.List;

import com.marketmanager.product.model.Electronic;


public class ElectronicController implements BaseController<Electronic> {
	
	private List<Electronic> electronics;
	private static ElectronicController instance;
	
	private ElectronicController() {
		electronics = new ArrayList<>();
	}


	public static ElectronicController getInstance() {
		if (instance == null) {
			instance = new ElectronicController();
		}

		return instance;
	}
	
	@Override
	public void add(Electronic product) {
		electronics.add(product);
	}

	@Override
	public List<Electronic> getAll() {	
		return electronics;
	}

}
