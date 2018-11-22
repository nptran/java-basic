package baitapso1;

import java.util.Scanner;

public class Bai06 {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a, b;

		System.out.println("Enter 1st number: ");
		a = scanner.nextInt();
		System.out.println("Enter 2nd number: ");
		b = scanner.nextInt();
		
		System.out.println("UCLN: " + Function.UCLN(a, b));
		System.out.println("BCNN: " + Function.BCNN(a, b));
	}

}
