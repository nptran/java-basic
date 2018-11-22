package com.classroommanager.model;

public class ClassRoom extends Room {
	private boolean projector;

	public String getProjector() {
		if(projector == true)
			return "Có";
		else return "Không";
	}

	public void setProjector(boolean projector) {
		this.projector = projector;
	}
	
}
