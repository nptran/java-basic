package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputStudent {

	private static Scanner sc = new Scanner(System.in);
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static Student input() {

		Student student = new Student();
		System.out.println("Code: ");
		String code = sc.nextLine();
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Gender: ");
		String gender = sc.nextLine();
		System.out.println("Date of Birth: ");
		LocalDate dob = LocalDate.parse(sc.nextLine(), DATE_FORMATTER);
		
		student.setCode(code);
		student.setName(name);
		student.setGender(gender);
		student.setDob(dob);
			
		return student;
	}

}
