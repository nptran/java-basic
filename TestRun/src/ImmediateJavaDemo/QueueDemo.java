package ImmediateJavaDemo;

import java.util.PriorityQueue;
/* 
 * Queue (Hang doi) rule: FIRST IN FIRST OUT - nguoc lai voi voi Stack.
 * */

public class QueueDemo {

	public static void main(String[] args) {
		PriorityQueue<String> q = new PriorityQueue<>();
	
		q.offer("1st");
		//q.add("first"); //neu add qua so luong phan tu cua queue thi se throw exception, offer thi khong.
		q.offer("2nd");
		q.offer("3rd");
		
		System.out.println(q);
		
		System.out.println("TOP is: " +q.peek()); //co the thay su khac biet giua queue va stack o day.
		q.poll(); //delete phan tu uu tien cao nhat
		System.out.println("After poll: " +q);
		
	}
}
