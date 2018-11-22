package com.management.view;

import java.util.Scanner;

import com.management.controller.CustomerController;
import com.management.model.Customer;
import com.management.model.Item;

public class CustomerView implements BaseView<Customer> {

	private static Scanner scanner = new Scanner(System.in);

	private CustomerController customerController = CustomerController.getInstance();
	
	@Override
	public void input() {
		
		Customer customer = new Customer();
		
		System.out.println("Customer's Name: ");
		String name = scanner.nextLine();
		System.out.println("Address: ");
		String address = scanner.nextLine();
		System.out.println("Phone Number: ");
		long phoneNumber = scanner.nextLong();
		scanner.nextLine();
		
		customer.setCode();
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhoneNumber(phoneNumber);
		
		customerController.add(customer);
		
	}

	@Override
	public void showList() {
		for(Customer customer : customerController.getAll()) {
			System.out.printf("CODE: " + customer.getCode() + "\nCustomer's Name: " + customer.getName() + "\nAddress: " + customer.getAddress() + "\nCost: " + customer.getPhoneNumber());
		}
		
	}

	
}
