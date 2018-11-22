package javabasic;

import java.util.Scanner;

public class B {
	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        int test=scan.nextInt();
	        
	        while(test-->0){
	        	int a=scan.nextInt();
	        	if(dauCuoi(a))
	        		System.out.println("YES");
	        	else
	        		System.out.println("NO");
	        }
	        scan.close();
	 }
	 private static boolean dauCuoi(int number) {
		 int dau=number%10, cuoi=0;
		 while (number!=0) {
			 cuoi =number%10;
			 number/=10;
		 }
		 if(dau==cuoi)
			 return true;
		 else
			 return false;
	 }
}
