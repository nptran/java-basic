package baitapso1;

import java.util.Random;
import java.util.Scanner;

public class Bai03 {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int inNum = scanner.nextInt();
		int outNum = 0;
		int step = 1;
		
		Random r = new Random();
		
		while(inNum !=outNum) {
			outNum = r.nextInt(90) + 10;
			System.out.println("Step " + (step++) + ": " + outNum + " --- " + inNum);
		}
	}
}
