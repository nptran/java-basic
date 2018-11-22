package baitapso1;

import java.util.Scanner;

public class Bai04 {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int sum = 0;
		
		if(n%2==0) {
			for (int i =0; i <=n; i+=2) {
				sum+=i;
			}
		}
		else {
			for (int i =1; i <=n; i+=2) {
				sum+=i;
			}
		}
		
		System.out.println(sum);
	}
}
