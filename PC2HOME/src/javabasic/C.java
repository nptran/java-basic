package javabasic;

import java.util.Scanner;

import javabasic.view.Function;

public class C {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int test=scanner.nextInt();
		while(test-->0) {
			int a=scanner.nextInt();
			if(Function.tongCS(a)%10==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		scanner.close();
	}
}
