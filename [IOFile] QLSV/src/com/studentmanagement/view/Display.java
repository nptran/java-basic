package com.studentmanagement.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.studentmanagement.IO.IOStudent;
import com.studentmanagement.controller.StudentController;
import com.studentmanagement.model.Student;

public class Display {
	
	private void showMenu() {
		System.out.println("1. Add");
		System.out.println("2. View Details");
		System.out.println("3. Exit");
	}
	private Scanner sc = new Scanner(System.in);
	
	public void run() throws IOException, ClassNotFoundException {
		StudentController controller = StudentController.getInstance();
		StudentView process = new StudentView();
		IOStudent io = new IOStudent();
	//	io.Clear();
		int choice = 0;
		
		showMenu();
		do {
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: //add
				
				List<Student> student = new ArrayList<>();
				
				io.OStudent(student);
				System.out.println("DONE!");
				showMenu();
				break;
			case 2: //View details
				List<Student> students = new ArrayList<>();
				students=io.IStudent();
				io.show(students);
				showMenu();
				break;
			case 3: //exit
				System.out.println("ARE YOU SURE? PRESS 'Y' TO YES!!! ");
				String cf = sc.nextLine();
				if (cf.equalsIgnoreCase("y")) {
					System.out.println("CLOSED!");
					break;	
				} else {
					choice = 0;
					showMenu();
					break;
				}
			default: 
				System.out.println("WRONG CHOICE, TRY AGAIN!!!");
				showMenu();
				break;
			}
		} while (choice != 3);
		
	}

}