package baitapso1;

import java.util.Scanner;

public class Bai17 {
	private static Scanner scanner = new Scanner(System.in);
	
	private static void pascalTriagle(int n) {
		for (int i=0; i<=n; i++) {
			for (int j=0; j<=i; j++) {
				System.out.print(Function.combination(j, i) + "  ");				
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		pascalTriagle(n);
	}
}
