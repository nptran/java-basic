package javabasic;

import java.util.Scanner;

public class X {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(), testCase = 0;
		scanner.nextLine();
		while (t-->0) {
			testCase++;
			
			String s1 = scanner.nextLine(), s2 = scanner.nextLine(), temp1 = s1.toLowerCase(), temp2 = s2.toLowerCase();
			int i =temp1.indexOf(temp2);
			while(i!=-1) {
				s1 = s1.substring(0, i) + s1.substring(i+s2.length());
				temp1 = temp1.substring(0, i) + temp1.substring(i+temp2.length());
				i =temp1.indexOf(temp2);
			}
			s1 = s1.trim();
			s1 = s1.replaceAll("\\s+"," ");
			System.out.println("Test "+testCase+": "+s1);
		}
		
		scanner.close();
	}
}
