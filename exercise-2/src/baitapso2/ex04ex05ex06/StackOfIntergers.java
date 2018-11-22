package baitapso2.ex04ex05ex06;

public class StackOfIntergers {
	private static int[] elements;
	private int size;

	//Khởi tạo mặc định
	public StackOfIntergers() {
		size = 16;
		elements = new int[size];
	}
	
	//Khởi tạo có tham số
	public StackOfIntergers(int size) {
		this.size = size;
		elements = new int[size];
	}
	
	public boolean isEmpty() {
		for(int n : elements) {
			if(n!=0)
				return false;
		}
		return true;
	}
	
	public boolean isFull() {
		for(int n : elements) {
			if(n!=0)
				return false;
		}
		return true;
	}
	
	public int peak() {
		for (int i=size-1; i>=0; i--) {
			if(elements[i]!=0)
				 return elements[i];
		}
		return 0;
	}
	
	public void push(int n) {
		int[] temp = elements;
		if (elements[size-1]!=0) { //tràn stack - outOfBounce
			size++; //tiến hành cấp phát động
			elements = new int[size];
			for (int i = 0; i < temp.length; i++) {
				elements[i] = temp[i];
			}
			elements[size-1] = n;
		}
		else {
			for (int i=0; i<size; i++) {
				if(elements[i]==0) {
					elements[i]=n;
					break;
				}
			}
		}
	}
	
	public int pop() {
		int top = peak();
		for (int i = size-1; i>=0; i--) {
			if(elements[i]!=0) {
				elements[i]=0;
				break;
			}
		}
		return top;
	}
	
	public int getSize() {
		for (int i=size-1; i>=0; i--) {
			if(elements[i]!=0)
				return i+1;
		}
		return 0;
	}
	
	public void show() {
		for(int i:elements) {
			System.out.println(elements[i]);
		}
	}
	
}
