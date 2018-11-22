package com.classroommanager.comparator;

import java.util.Comparator;

import com.classroommanager.model.Room;

public class LightsComparator implements Comparator<Room> {

	@Override
	public int compare(Room o1, Room o2) {
		if (o1.getLights() > o2.getLights())
			return 1;
		else if (o1.getLights() == o2.getLights())
			return 0;
		else 
			return -1;
	}
	
	

}
