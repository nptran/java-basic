package javabasic;

import java.util.Scanner;

public class J {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t = scanner.nextInt();
		while (t-->0) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int count=1;
			nhap(a);
			
			if (2<=n && n<=50 && daySoDuong(a)) {
				for (int i=1; i<n; i++) {
					if(a[i]>=a[i-1])
						count++;
				}
				System.out.println(count);
			}
		}
	}
	
	public static void nhap(int[] a) {
		for (int i =0; i<a.length; i++) {
			a[i] = scanner.nextInt();
		}
	}
	
	public static boolean daySoDuong(int[] a) {
		for (int i=0; i<a.length; i++) {
			if(a[i]<=0)
				return false;
		}
		return true;
		
	}
}
