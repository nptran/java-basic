package com.classroommanager.comparator;

import java.util.Comparator;

import com.classroommanager.model.Room;

public class BlockComparator implements Comparator <Room>{

	@Override
	public int compare(Room o1, Room o2) {
		return (o1.getBlock().compareToIgnoreCase(o2.getBlock()));
	}

	
}
