package javabasic;

import java.util.Scanner;

public class I {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t = scanner.nextInt();
		int testCase = 0; 
		while(t-->0) {
			testCase++;
			int N,M,p;
			do {
				N =scanner.nextInt();
				M =scanner.nextInt();
				p =scanner.nextInt();
			} while (0>p || p>=M || M>N || N >=100);
			
			int[] a = new int[N], b = new int[M];
			nhap(a);
			nhap(b);
			a = chen(a, b, p);
			System.out.println("Test "+testCase+":");
			hienThi(a);
		}
	}
	
	public static int[] chen(int[] a, int[] b, int vt) {
		int[] temp = new int[a.length+b.length];
		int index = 0;
		for (int i=0; i<vt; i++) {
			temp[index++] = a[i];
		}
		for (int i=0; i<b.length; i++) {
			temp[index++] = b[i];
		}
		for (int i=vt; i<a.length; i++) {
			temp[index++] = a[i]; 
		}
		a=new int[temp.length];
		a=temp;
		return a;
	}
	
	public static void nhap(int[] a) {
		for (int i =0; i<a.length; i++) {
			a[i] = scanner.nextInt();
		}
	}
	
	public static void hienThi(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + "  ");
		}
	}

}
