package com.management.view;

import java.util.Scanner;

import com.management.model.Customer;
import com.management.model.Item;

public class Display {
	
	private void Menu() {
		System.out.println("a. Add Item");
		System.out.println("b. Add Customer");
		System.out.println("c. View List Items");
		System.out.println("d. View List Customer");
		System.out.println("e. Exit");
	}

	private static Scanner scanner = new Scanner(System.in);

	public void displayInfo() {

		ItemView itemView = new ItemView();
		CustomerView customerView = new CustomerView();
		
		String choice = "";
		Menu();
		
		do {	
			
			choice = scanner.nextLine();
				
			switch (choice) {
			case "a": //input item
				itemView.input();
				Menu();
				break;
			case "b": //input customer
				customerView.input();
				Menu();
				break;
			case "c": //show list item
				itemView.showList();
				Menu();
				break;
			case "d": //show list customer
				itemView.showList();
				Menu();
				break;
			case "e": 
				System.out.println("EXITED");
				break;
			default:
				System.out.println("Wrong Choice!");
				Menu();
				break;
			}
		} while (!choice.equalsIgnoreCase("e"));
		
	}
	
}
