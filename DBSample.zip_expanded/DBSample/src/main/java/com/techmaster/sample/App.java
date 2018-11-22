package com.techmaster.sample;

import com.techmaster.sample.controller.StudentClassController;
import com.techmaster.sample.controller.StudentController;
import com.techmaster.sample.model.Student;

/**
 * Hello world!
 *
 */


public class App {
	
	private static void showMenu() {
		System.out.println("1. Add Class");
		System.out.println("2. Add Student");
		System.out.println("3. ");
	}
	
	public static void main(String[] args) {

		StudentClassController classController = new StudentClassController();
		// StudentClass stdClass = new StudentClass();
		//
		// stdClass.setName("1A");
		// classController.insertClass(stdClass);

		StudentController stdController = new StudentController();
		Student std = new Student();
		std.setName("Hiep");
		std.setStudentClass(classController.getByName("2A"));
		stdController.insertStudent(std);

	}
}
