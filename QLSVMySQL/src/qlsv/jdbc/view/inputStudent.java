package qlsv.jdbc.view;

import java.util.Scanner;

import qlsv.jdbc.model.Student;

public class inputStudent {

	private static Scanner scanner = new Scanner(System.in);
	
	public Student input() {
				
		System.out.println("Enter ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter name: ");
		String name = scanner.nextLine();
		System.out.println("Enter age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		
		Student student = new Student(id, name, age);
		return student;
				
	}
}
