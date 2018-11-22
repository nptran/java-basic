package javabasic;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class M {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] a = new int[50000];
		int index=0;
		Set<Integer> set = new LinkedHashSet<>();
		while (scanner.hasNextInt()) {
			int n =scanner.nextInt();
			if(csNT(n)) {
				a[index++] = n;
			}
		}
		for (int i=0; i<index; i++) {
			set.add(a[i]);
		}
		for (int num : set) {
			System.out.println(num+" "+dem(num, a));
		}
		scanner.close();
	}
	
	public static boolean csNT(int number) {
		while(number!=0) {
			if(number%10!=2 && number%10!=3 && number%10!=5 && number%10!=7) {
				return false;
			}
			number/=10;
		}
		return true;
	}
	
	private static int dem(int n, int[] a) {
		int count = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i]==n)	count++;
		}
		return count;
	}
}
