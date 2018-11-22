package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance;
	private static int costOfCourse = 600; 
	private static int id = 1000;
	
	//Constructor: prompt user to enter name and year
	@SuppressWarnings("resource")
	public Student() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEnter first name: ");
		this.firstName = scanner.nextLine();
		System.out.println("Enter last name: ");
		this.lastName = scanner.nextLine();
		System.out.println("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
		this.gradeYear = scanner.nextInt();
		scanner.nextLine();
		
		setStudentID();
		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);
	}
	
	//Generate an ID
	private void setStudentID() {
		//Grade level + id
		this.studentID = gradeYear + "" + id;
		id++;
	}
	//Enroll in courses
	public void enroll() {
		//Get inside the loop, user hits 0
		while (true) {
			System.out.print("Enter course to enroll (Q to quit): ");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String course = scanner.nextLine();
	
			if(!course.equalsIgnoreCase("q")) {
				courses+= "\n " + course;
				tuitionBalance+=costOfCourse;
			}
			else break;
		}
	}
	
	//View balance
	private void viewBalance() {
		System.out.println("Your Balance is: $" + tuitionBalance);
	}
	
	//Pay tuition
	public void payTuition () {
		viewBalance();
		System.out.print("Enter your payment: $");
		@SuppressWarnings("resource")
		int payment = new Scanner(System.in).nextInt();
		tuitionBalance-=payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	//Show status
	public void showInfo() {
		System.out.println("\nName: " + firstName + " " + lastName +
				"\nGrade Level: " + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance);
	}

}
