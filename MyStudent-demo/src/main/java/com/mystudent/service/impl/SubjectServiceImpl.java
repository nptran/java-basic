/**
 * 
 */
package com.mystudent.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudent.model.Subject;
import com.mystudent.repository.SubjectRepository;
import com.mystudent.service.SubjectService;

/**
 * @author Phuc Tran
 *
 */
@Service
public class SubjectServiceImpl implements SubjectService {

	private SubjectRepository repository;
	
	@Autowired
	public SubjectServiceImpl(SubjectRepository repository) {
		this.repository = repository;
	}
	
	public Iterable<Subject> getAll() {
		return repository.findAll();
	}

	public Optional<Subject> getOne(Integer id) {
		return repository.findById(id);
	}

	public void save(Subject subject) {
		repository.save(subject);
	}

	public Subject getForMark(Integer id) {
		return repository.getOne(id);
	}

//	public List<Student> getStudentFrom() {
//		return ;
//	}

}
