package baitapso1;

import java.util.Scanner;

public class Bai05 {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n =0;
		double sum =0;
		
		do {
			n = scanner.nextInt();
		} while (n==0);
		
		for (double i =1; i <=n; i++) {
			sum +=(1/i);
		}
		System.out.printf("%.3f", sum);
	}

}
