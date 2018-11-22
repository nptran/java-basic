package baitapso1;

import java.util.Scanner;

public class Bai10 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	//to print n prime numbers
	private static void printPrime(int n) {
		int counter = 0;
		int i=2;
		
		while(counter !=n) {
			if(Function.isPrime(i)) {
				System.out.print(i + "  ");
				counter++;
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		printPrime(n);
	}

}
