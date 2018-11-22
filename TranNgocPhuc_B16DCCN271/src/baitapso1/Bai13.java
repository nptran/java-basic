package baitapso1;

import java.util.Scanner;

public class Bai13 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	static double Pi(double c) {
		double pi = 0;
		int n =0;
		while (1/((2*n)+1)>c) {
			pi+= Math.pow(-1, n)/((2*n)+1);
			n++;
		}
		pi*=4;
		return pi;
	}
	
	public static void main(String[] args) {
		double c = scanner.nextDouble();
		System.out.printf("%.6f", Pi(c));
	}

}
