package com.techmaster.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techmaster.model.Student;

public class App {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>(); //mang dssv

		showMenu(); //hien thi Menu

		String choice = null;
		Scanner scanner = new Scanner(System.in);

		do {
			choice = scanner.nextLine();
			
			switch (choice) {
			case "a": {
				if (students.isEmpty()) {
					System.out.println("Khong co sinh vien nao");
				} else {
					for (Student student : students) {
						System.out.println(student.getCode() + " " + student.getName() + " " + student.getAge() + " ");
					}
				}
				showMenu();
				break;
			}

			case "b": {
				Student student = new Student();

				scanner = new Scanner(System.in);

				System.out.println("Ma sinh vien: ");
				String code = scanner.nextLine();
				student.setCode(code);

				System.out.println("Ten sinh vien: ");
				String name = scanner.nextLine();
				student.setName(name);

				System.out.println("Tuoi: ");
				String age = scanner.nextLine();
				student.setAge(Integer.parseInt(age)); //convert String sang int

				students.add(student);

				showMenu();
				break;
			}

			case "c": {
				System.out.println("Nhap MSV muon xoa: ");
				String code = scanner.nextLine();
				Student foundStudent = null;
				
				for (Student student : students) {
					if (code.equalsIgnoreCase(student.getCode())){
						foundStudent = student;
					}		
				}
				
				if (foundStudent != null){
					students.remove(foundStudent);
				}else {
					System.out.println("khong tim thay sv.");}		
			
				showMenu();
				break;
			}

			case "d": {
				System.out.println("Goodbye");
				break;
			}

			default: {
				System.out.println("Wrong Choice");
				break;
			}
			}
		} while (!choice.equals("d"));
		

	}

	private static void showMenu() {
		System.out.println("a. Danh sach sinh vien");
		System.out.println("b. Them sinh vien");
		System.out.println("c. Xoa sinh vien");
		System.out.println("d. Thoat");
	}
		
}