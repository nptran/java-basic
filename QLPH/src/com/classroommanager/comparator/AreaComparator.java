package com.classroommanager.comparator;

import java.util.Comparator;

import com.classroommanager.model.Room;

public class AreaComparator implements Comparator <Room> {

	@Override
	public int compare(Room o1, Room o2) {
		if (o1.getArea() > o2.getArea())
			return -1;
		else if (o1.getArea() == o2.getArea())
			return 0;
		else
			return 1;
	}

}
