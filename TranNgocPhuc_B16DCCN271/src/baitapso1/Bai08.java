package baitapso1;

import java.util.Scanner;

public class Bai08 {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		System.out.println(Function.sumOfDigits(n, 0));
	}

}
