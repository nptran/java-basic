package baitapso1;

import java.util.Scanner;

public class Bai07 {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter 1st number: ");
		int a = scanner.nextInt();
		System.out.println("Enter 2nd number: ");
		int b = scanner.nextInt();

		for (int i = ((a<b) ? a:b) ; i <= ((a<b) ? b:a); i++) {
			for (int j = i ; j <= ((a<b) ? b:a); j++) {
				if (Function.UCLN(i, j)==1)
					System.out.println(i +" "+ j);
			}
		}
	}
}
