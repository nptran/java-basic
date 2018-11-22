package javabasic;

import java.util.Scanner;

public class Z {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n =1, index=0;
		int[] count = new int[100];
		
		do {
			n =scanner.nextInt();
			if(n!=0) {
				scanner.nextLine();
				String s1 = scanner.nextLine(), s2 = scanner.nextLine(), S = scanner.nextLine(), s = new String();
				while (!s.equals(S)) {
					if(s1.length()==n && s2.length()==n) {
						s = mixString(s1, s2);
						s1= s.substring(0, n); s2= s.substring(n, n+n);
						count[index]++;
					}
					if(count[index]>n*n) {
						count[index]=-1;
						break;
					}
				}
			}
			index++;
		} while (n!=0);
		
		for(int i=0; i<100; i++) {
			if(count[i]!=0) {
				System.out.println(count[i]);
			}
		}
		
		scanner.close();
	}
	
	private static String mixString(String s1, String s2) {
		String s = new String();
		int index = 0;
		while (index < (s1.length() ) ) {
			s += s2.substring(index, index+1) + s1.substring(index, index+1);
			index++;
		}
		
		return s;
	}

}
