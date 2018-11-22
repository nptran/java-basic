package javabasic;

import java.util.Scanner;

public class F {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t=scanner.nextInt();
		while(t-->0) {
			int size=scanner.nextInt();
			int[] a = new int[size];
			nhap(a);
			if (doiXung(a))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	public static void nhap(int[] a) {
		for (int i =0; i<a.length; i++) {
			a[i] = scanner.nextInt();
		}
	}
	
	public static boolean doiXung(int[] a) {
		int n = a.length;
		for (int i =0; i<n/2; i++) {
			if(a[i]!=a[n-i-1])
				return false;
		}
		return true;
	}
}
