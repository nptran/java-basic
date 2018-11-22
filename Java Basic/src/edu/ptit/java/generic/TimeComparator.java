/**
 * 
 */
package edu.ptit.java.generic;

import java.util.Comparator;

/**
 * @author Phuc Tran
 *
 */
public class TimeComparator implements Comparator<Pair<?,BTL>>{
	
	@Override
	public int compare(Pair<?, BTL> o1, Pair<?,BTL> o2) {
		if(o1.getSecond().getTime() > o2.getSecond().getTime()) {
			return -1;
		}
		else if (o1.getSecond().getTime() == o2.getSecond().getTime()) {
			return 0;
		}
		return 1;
	}

}
