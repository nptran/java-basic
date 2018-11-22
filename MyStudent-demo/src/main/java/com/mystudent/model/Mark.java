/**
 * 
 */
package com.mystudent.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * @author Phuc Tran
 *
 */

@Entity
@Table(name="Mark")
public class Mark {
	
	@EmbeddedId
	private MarkKey id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("studentId")
	private Student student;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("subjectId")
	private Subject subject;
	
	private Double studentmark ;
	
	public Mark() {	id = new MarkKey(); }
	 
    public Mark(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
        this.id = new MarkKey(student.getId(), subject.getId());
    }

	public MarkKey getId() {
		return id;
	}

	public void setId(MarkKey id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Double getStudentmark() {
		return studentmark;
	}

	public void setStudentmark(Double studentmark) {
		this.studentmark = studentmark;
	}

}
