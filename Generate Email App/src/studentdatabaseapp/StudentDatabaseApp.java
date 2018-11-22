package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//Ask how many students you want to add
		System.out.println("Enter numbers of students to enroll:");
		int numOfStudent = new Scanner(System.in).nextInt();
		Student[] students = new Student[numOfStudent];
		
		//Create n number of new students
		for (int n=0; n < students.length; n++) {
			String keepIn = "";
			if (n>0 && n < students.length) {
				System.out.println("<Enter X to stop>");
				keepIn = new Scanner(System.in).nextLine();
			}
			if (!keepIn.equalsIgnoreCase("X")) {
				students[n] = new  Student();
				students[n].enroll();
				students[n].payTuition();
			} else break;
			
		}
		
		for (int n=0; n < students.length; n++) {
			if(students[n] != null) {
				students[n].showInfo();
			}
		}
	}

}
