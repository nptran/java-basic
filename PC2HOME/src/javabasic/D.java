package javabasic;

import java.util.Scanner;

import javabasic.view.Function;

public class D {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t=scanner.nextInt();
		while (t-->0) {
			int n=scanner.nextInt(), count=0;
			for (int i=(int) Math.pow(10, n-1); i<Math.pow(10, n); i++) {
				if (Function.thuanNgich(i) && Function.tongCS(i)%10==0) {
					count++;
				}
			}
			System.out.println(count);
		}
		scanner.close();
	}

}
