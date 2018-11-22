package baitapso1;

import java.util.Scanner;

public class Bai11 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static void printFibo(int n) {
		int counter = 0;
		int i =0;
		while (counter!=n) {
			System.out.print(Function.fibonacci(i++) + "  ");
			counter++;
		}
	}
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		printFibo(n);
	}

}
