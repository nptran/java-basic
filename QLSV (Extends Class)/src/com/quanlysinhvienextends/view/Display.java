package com.quanlysinhvienextends.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.quanlysinhvienextends.controller.LecturerController;
import com.quanlysinhvienextends.controller.StudentController;

import com.quanlysinhvienextends.model.Lecturer;
import com.quanlysinhvienextends.model.Student;

public class Display {
	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static Scanner sc = new Scanner(System.in);
	
	private static void showMenu() {
		
		System.out.println("1. Thêm sinh viên");
		System.out.println("2. Hiển thị danh sách sinh viên");
		System.out.println("3. Thêm giảng viên");
		System.out.println("4. Hiển thị danh sách giảng viên");
		System.out.println("5. Hiển thị danh sách lớp");
		System.out.println("6. Thoát");
		
	}

//dialog
	private static String wrg = "LỰA CHỌN KHÔNG TỒN TẠI. VUI LÒNG CHỌN LẠI!";
	private static String done = "THÊM THÀNH CÔNG!!!";
	private static String empty = "DANH SÁCH TRỐNG!!!";
	private static String exist = "MÃ NÀY ĐÃ TỒN TẠI. VUI LÒNG NHẬP MÃ MỚI!!!";
	//
	
	private static LecturerController lcontroller = new LecturerController();
	private static List<Lecturer> lecturers = lcontroller.getLecturer();
	
	private static StudentController scontroller = new StudentController();
	private static 	List<Student> students = scontroller.getStudent();
	
	
	private Student inputStudent() {
		String code;
		boolean check = false;
		do {
			System.out.println("Mã sinh viên:");
			code = sc.nextLine();

			for (Student found : students) {
				if (code.equalsIgnoreCase(found.getCode())) {
					System.out.println(exist);
					check = true;
				}
	
			}
			
		} while (check != false);
		
		System.out.println("Tên sinh viên:");
		String name = sc.nextLine();
		
		System.out.println("Ngày sinh:");
		String dob = sc.nextLine();
		
		System.out.println("Lớp:");
		String group = sc.nextLine();
		
		System.out.println("Điểm Trung Bình:");
		double avgscore = sc.nextDouble();
		sc.nextLine();
		
		Student student = new Student();
		
		student.setCode(code);
		student.setName(name);
		student.setDob(LocalDate.parse(dob, DATE_FORMATTER));
		student.setGroup(group);
		student.setAvgscore(avgscore);
		
		return student;
		
	}
	
	private Lecturer inputLecturer() {
		
		String code;
		boolean check = false;
		do {
			System.out.println("Mã giảng viên:");
			code = sc.nextLine();

			for (Lecturer found : lecturers) {
				if (code.equalsIgnoreCase(found.getCode()))
					System.out.println(exist);
				else check = true;
				
			}
		} while (check != false);
		
		System.out.println("Tên giảng viên:");
		String name = sc.nextLine();
		
		System.out.println("Ngày sinh:");
		String dob = sc.nextLine();
		
		System.out.println("Lớp:");
		String group = sc.nextLine();
		
		System.out.println("Tiền lương:");
		int salary = sc.nextInt();
		sc.nextLine();
		
		Lecturer lecturer = new Lecturer();
		lecturer.setCode(code);
		lecturer.setName(name);
		lecturer.setDob(LocalDate.parse(dob,DATE_FORMATTER));
		lecturer.setGroup(group);
		lecturer.setSalary(salary);

		return lecturer;

	}
 
	private void displayStudent() {
		if(students.isEmpty()) System.out.println(empty);
		else {
			for (Student student : students) {
				System.out.println(student.getCode() + " " + student.getName() + " " + student.getGroup() + " " + student.getDob() + " " + student.getAvgscore());
			}
		}
	}
	
	private void displayLecturer() {
		if (lecturers.isEmpty()) System.out.println(empty);
		else {
			for (Lecturer lecturer : lecturers) {	
				System.out.println(lecturer.getCode() + " " + lecturer.getName() + " " + lecturer.getDob() + " " + lecturer.getGroup() + " " + lecturer.getSalary());
			} 
		}
	}
	
	private void displayGroup() {
		System.out.println("Tên lớp:");
		String group = sc.nextLine();
		System.out.println("Giảng viên:");
		for (Lecturer lecturer : lecturers) {
			if (lecturer.getGroup().equalsIgnoreCase(group)) {
				System.out.println(lecturer.getCode() + " " + lecturer.getName());
			}
		
		}
		System.out.println("Danh sách sinh viên:");
		int counter = 0;
		for (Student student : students) {
			if (student.getGroup().equalsIgnoreCase(group)) {
				++counter;
				System.out.println(counter + ". " + student.getCode() + " " + student.getName());
			}
		}
		
		System.out.println("Tổng số sinh viên: " + counter);
		System.out.println("==============================");
	}
	
	public void run() {
		
		int choice = 0;
		showMenu();
		
		do {
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			
			case 1: //add student
			{
				Student student = inputStudent();
				scontroller.addStudent(student);
				System.out.println(done);
				
				showMenu();
				break;
			}	
			
			case 2: //view student
				displayStudent();
				showMenu();
				break;
				
			case 3: // add lecturer
			{
				Lecturer lecturer = inputLecturer();
				lcontroller.addLecturer(lecturer);
				System.out.println(done);
				
				showMenu();
				break;
			}
			
			case 4: //view lecturer		
				displayLecturer();
				showMenu();
				break;
			
			
			case 5:	//view group
				displayGroup();
				showMenu();
				break;
			
			
			case 6: //exit
				System.out.println("ĐÃ THOÁT!");
				break;
			
			default:
					System.out.println(wrg);
					showMenu();
					break;
			
			}
			
		} while (choice != 6);
		
	
		sc.close();
	}
}
