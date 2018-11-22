package emailapp;

import java.util.Scanner;

public class Email {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private String password;
	private int defaultpasswordLength = 10;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = ".oracle.com";
	
	//Constructor to receive first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Full Name: "+ this.firstName + " " + this.lastName);
		
		//generate the department
		this.department = setDepartment();
		
		//call method that returns a random password
		this.password = randomPassword(defaultpasswordLength);
		System.out.println("Your password is: " + this.password);
		
		//combine elements to generate email
		email =  firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + companySuffix;
	}
	
	//ask for the department
	private String setDepartment() {
		System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		int departmentChoice = scanner.nextInt();
		if (departmentChoice == 1) return "Sales";
		else if (departmentChoice == 2) return "Dev";
		else if (departmentChoice ==3) return "Acct";
		else return "None";
	}
	
	//Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length()); //random() method return a double type so we need cast to integer
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set the mail box capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {	return mailboxCapacity;	}
	public String getAlternateEmail() {	return alternateEmail;	}
	public String getPassword() {	return password;	}
	
	public void showInfo() {
		System.out.println("NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAIL BOX CAPACITY: "+ mailboxCapacity + "Mb\n");
	}

}
