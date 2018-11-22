package ImmediateJavaDemo;

import java.util.Stack;

public class StackDemo {

	/*
	 * Stack(Ngan Xep) phan tu push vao sau se duoc dua len dau. - rule: first in last out.
	 */
	public static void main(String[] args) {
	
		Stack<String> s = new Stack<String>();
		s.push("1st");
		s.push("2nd");
		s.push("3rd");
		
		System.out.println(s);
		System.out.println("TOP is: " + s.peek());
		
		s.pop();
		System.out.println("After pop: "+s);
		
	//	System.out.println(s.search("2nd push"));
	}
	
}
