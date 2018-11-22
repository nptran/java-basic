package javabasic.view;

public class Function {
	public static int tongCS(int number) {
		int sum=0;
		while(number!=0) {
			sum+=number%10;
			number/=10;
		}
		return sum;
	}
	
	public static boolean thuanNgich(int number) {
		String str = String.valueOf(number), r =new StringBuffer(str).reverse().toString();
		if(str.equals(r))
			return true;
		else
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
	
	public static boolean csNT(int number) {
		while(number!=0) {
			if(number%10!=2 && number%10!=3 && number%10!=5 && number%10!=7) {
				return false;
			}
			number/=10;
		}
		return true;
	}
	
	public static boolean thuanNT(int number) {
		if (soNT(number) && soNT(tongCS(number)) && csNT(number))
			return true;
		return false;
	}
	
	public static int[] sapTang(int[] a) {
		for (int i=0; i<a.length; i++) {
			for (int j=i; j<a.length; j++) {
				if(a[i]>a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	
	public static int[] sapGiam(int[] a) {
		for (int i=0; i<a.length; i++) {
			for (int j=i; j<a.length; j++) {
				if(a[i]<a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	
	private static boolean bangNhau(int[] a, int[] b) {
		if (a.length==b.length) {
			for (int i=0; i<a.length; i++) {
				if(a[i]!=b[i])
					return false;
			}
			return true;
		}
		else
			return false;
	}
	
	public static int[] xoaTrungLap(int[] a) {
		int size = a.length;
		for (int i=0; i<size-1; i++) {
			for (int j=i+1; j< a.length; j++) {
				if (a[i] == a[j]) {
					for (int k=j; k<a.length-1;k++) {
						a[k] = a[k+1];
					}
					size--;
				}
			}
		}
		int[] temp = a;
		a = new int[size];
		for(int i=0; i<a.length; i++) {
			a[i] = temp[i];
		}
		return a;
	}
	
}
