package baitapso1;

import java.util.Scanner;

public class Bai01 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int size = scanner.nextInt();
		
		for (int row =0; row <size; row++) {
			for (int col =0; col <size; col++) {
				if (row ==0 || row ==size-1 || col ==0 || col ==size-1) {
					System.out.print("*");
				}
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
