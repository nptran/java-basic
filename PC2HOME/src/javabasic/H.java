package javabasic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class H {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t = scanner.nextInt(), testCase = 0;
		Set<Integer> soNT = new HashSet<>();
		Set<Integer> sapxep = new TreeSet<>();

		while (t-->0) {
			testCase++;
			int n = scanner.nextInt();
			int[] a = new int[n];
			nhap(a);
			//xoa phan tu trung nhau
			for (int i=0; i<a.length; i++) {
				if (soNT(a[i])) {
					soNT.add(a[i]);
				}
			}
			//sap xep tang dan
			sapxep.addAll(soNT);
			//in ket qua
			System.out.println("Test " + testCase +":");
			for (int num : sapxep) {
				int count = dem(num, a);
				if (count!=0)
					System.out.println(num + " xuat hien " + count + " lan");
			}
		}
	}

	private static void nhap(int[] a) {
		for (int i =0; i<a.length; i++) {
			do {
				a[i] = scanner.nextInt();
			} while (a[i]<0);
		}
	}
	
	private static boolean soNT(int number) {
		if (number<2)
			return false;
		else {
			for (int i=2; i<=Math.sqrt(number); i++) {
				if (number%i==0)
					return false;
			}
		}
		return true;
	}
	
	private static int dem(int n, int[] a) {
		int count = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i]==n)
				count++;
		}
		return count;
	}

}
