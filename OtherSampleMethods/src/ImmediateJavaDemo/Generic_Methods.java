package ImmediateJavaDemo;

/* GENERIC METHOD (Hàm tổng quát) là một sự thay thế nhanh gọn thay vì sử dụng Overloaded Method
 * */

public class Generic_Methods {
	
	public static void main(String[] args) {
		Character[] c = {'p', 'h', 'u', 'c'};
		Integer[] i = {1, 2, 3, 4};
		
		printME(c);
		printME(i);
	}
	
	//HÀM TỔNG QUÁT
	static <T> void printME(T[] g) { //với T là một kiểu dữ liệu tống quát
		for (T t : g) {
			System.out.println(t);
		}
	}

	//THAY VÌ SỬ DỤNG CÁC OVERLOADED METHODS.
/*	static void printME(Character[] c) {
		for (Character j : c) {
			System.out.println(j);
		}
	}															
	static void printME(Integer[] i) {
		for (int a : i) {
			System.out.println(a);
		}
	}
*/
	
}
