package baitapso1;

import java.util.Scanner;

public class Bai02 {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int size = scanner.nextInt();
		
		for (int row =1; row <=size; row++) {
			int index =1;
			for (int col =1; col <=size; col++) {
				//Loop to print white-space
				for (int i = 1; i <=(size-row); i++) {
					System.out.print(" ");
				}
				
				//Loop to print numbers
				while (index <=row && index >0) {
					if(index <row) {
						System.out.print(index++);
					}
					else {
						while (index>0) {
							System.out.print(index--);
						}
					}
				}
			}
			System.out.println();
		}
	}

}
