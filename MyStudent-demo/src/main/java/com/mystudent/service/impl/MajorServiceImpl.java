/**
 * 
 */
package com.mystudent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudent.model.Major;
import com.mystudent.repository.MajorRepository;
import com.mystudent.service.MajorService;

/**
 * @author Phuc Tran
 *
 */
@Service
public class MajorServiceImpl implements MajorService {

	private MajorRepository repository;
	
	@Autowired
	public MajorServiceImpl(MajorRepository repository) {
		this.repository = repository;
	}
	
	public Iterable<Major> getAll() {
		return repository.findAll();
	}

	public void save(Major major) {
		repository.save(major);
	}

	public boolean isFound(Integer id) {
		return repository.existsById(id);
	}

}
