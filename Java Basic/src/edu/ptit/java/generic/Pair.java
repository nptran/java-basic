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
public class Pair<T, S> {
	
	private T first;
	private S second;
	private List<Pair<T,S>> list = new ArrayList<>();
	
	public Pair() {	}
	
	public void create(T t, S s){
		Pair<T, S> pair = new Pair<T,S>(t,s);
		list.add(pair);
	}
	
	protected Pair(T first, S second) {
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return first;
	}

	public S getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return first+" vs. "+second;
	}
	
	public void printList() {	
		for(Pair<T, S> p : list) {
			System.out.println(p);
		}
	}

	public List<Pair<T,S>> getList() {
		return list;
	}
	
}
