package javabasic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class K {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t=scanner.nextInt();
		int testCase = 0;
		while (t-->0) {
			testCase++;
			int n=scanner.nextInt();
			int[] a = thuaSoNT(n);
			System.out.printf("\nTest %d: ", testCase);
			Set<Integer> set = new HashSet<>();
			for (int i=0; i<9; i++) {
				if(a[i]!=0)
					set.add(a[i]);
			}
			for (int num : set) {
				System.out.printf("%d(%d) ", num, dem(num, a));
			}
		}
		scanner.close();
	}
	
	public static int[] thuaSoNT(int n) {
		int[] a = new int[9];
		int index =0;
		while(n!=1) {
			for(int i=2; i<=n; i++) {
				if(soNT(i)) {
					if (n%i==0) {
						n/=i;
						a[index++] = i;
					}
				}
			}
		}
		return a;
	}
	
	private static int dem(int n, int[] a) {
		int count = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i]==n)
				count++;
		}
		return count;
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
