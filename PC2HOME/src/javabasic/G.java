package javabasic;

import java.util.Scanner;

public class G {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t=scanner.nextInt();
		while (t-->0) {
			int d=scanner.nextInt(), count=0;
			for (int i=(int)Math.pow(10, d-1); i<Math.pow(10, d); i++) {
				if (tangGiam(i, d) && soNT(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
		scanner.close();
	}

	private static boolean dayTang(int[] a) {
		for (int i=0; i<a.length-1;i++) {
			if(a[i]>=a[i+1])
				return false;
		}
		return true;
	}
	
	private static boolean dayGiam(int[] a) {
		for (int i=0; i<a.length-1;i++) {
			if(a[i]<=a[i+1])
				return false;
		}
		return true;
	}
	
	private static boolean tangGiam(int so, int soCS) {
		int[] a = new int[soCS];
		int i = 0;
		while (so!=0) {
			a[i++] = so%10;
			so/=10;
		}
		if (dayGiam(a)||dayTang(a))
			return true;
		return false;
	}
	
	public static boolean soNT(int number) {
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
}
