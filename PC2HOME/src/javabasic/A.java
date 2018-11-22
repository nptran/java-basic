package javabasic;

import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int a=scanner.nextInt(),b=scanner.nextInt(),x=gcd(a,b);
            System.out.println(x+" "+(long)a*b/x);
        }
        scanner.close();
    }
    public static int gcd(int a,int b){
        return (b==0?a:gcd(b,a%b));
    }
}
