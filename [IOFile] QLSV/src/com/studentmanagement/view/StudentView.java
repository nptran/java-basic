package com.studentmanagement.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.studentmanagement.model.Student;

public class StudentView implements BaseView <Student> {

	private Scanner sc = new Scanner(System.in);
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public Student input(Student person) {
		
		System.out.println("_____________Enter Information_____________");
		System.out.println("CODE:");
		String code = sc.nextLine();
		
		System.out.println("Name:");
		String name = sc.nextLine();
		
		System.out.println("Gender:" );
		String gender = sc.nextLine();
		
		System.out.println("Date Of Birth:");
		String dob = sc.nextLine();
		
		System.out.println("Score:");
		double score = sc.nextDouble();
		sc.nextLine();
		
		person.setCode(code);
		person.setName(name);
		person.setDob(LocalDate.parse(dob, DATE_FORMATTER));
		person.setScore(score);
		person.setGender(gender);
		
		return person;
	}

}
