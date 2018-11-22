package com.management.controller;

import java.util.ArrayList;
import java.util.List;

import com.management.model.Customer;

public class CustomerController implements BaseController<Customer> {

	private List<Customer> customers;
	private static CustomerController instance;
	
	private CustomerController() {
		customers = new ArrayList<>();
	}
	
	public static CustomerController getInstance() {
		if(instance == null) {
			instance = new CustomerController();
		}
		return instance;
	}

	@Override
	public void add(Customer customer) {
		customers.add(customer);
	}

	@Override
	public List<Customer> getAll() {
		return customers;
	}
	
	

}
