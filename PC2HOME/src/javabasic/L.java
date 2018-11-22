package javabasic;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] a = new int[50000];
		int index=0;
		Set<Integer> set = new LinkedHashSet<>();
		while (scanner.hasNextInt()) {
			int n =scanner.nextInt();
			if(thuanNgich(n)) {
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
	
	public static boolean thuanNgich(int number) {
		String str = String.valueOf(number), r =new StringBuffer(str).reverse().toString();
		if(str.equals(r))
			return true;
		else
			return false;
	}
	
	private static int dem(int n, int[] a) {
		int count = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i]==n)	count++;
		}
		return count;
	}

}
