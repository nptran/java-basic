/**
 * 
 */
package edu.ptit.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Phuc Tran
 *
 */
public abstract class BaseInfo<T> {
	
	protected int code;
	protected String name;
	private List<T> list;
	
	public abstract void input();
	
	public void add(T elm) {
		if(list == null) {
			list = new ArrayList<>();
		}
		list.add(elm);
	}
	
	public List<T> getList() {
		return list;
	}
	
	public int getCode() {
		return code;
	}

	public void printList() {
		for(T elm : list) {
			System.out.println(elm.toString());
		}
	}
	
}
