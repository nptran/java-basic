package com.techmaster.sample.view;

import java.util.Scanner;

import com.techmaster.sample.controller.StudentClassController;
import com.techmaster.sample.controller.StudentController;
import com.techmaster.sample.model.Student;
import com.techmaster.sample.model.StudentClass;

public class Input {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public Student inputStudent(StudentController stdController, StudentClassController classController) {
		classController = new StudentClassController();
		
		Student student = new Student();
		
		System.out.println("Name: ");
		String name = scanner.nextLine();
		
		System.out.println("Class: ");
		String classid = scanner.nextLine();

		student.setName(name);
		student.setStudentClass(classController.getByName(classid));
		return student;
	}
	
	public StudentClass inputStudentClass() {
		StudentClass studentClass = new StudentClass();
		System.out.println("Class name: ");
		String name = scanner.nextLine();
		studentClass.setName(name);
		
		return studentClass;
		
	}

}
