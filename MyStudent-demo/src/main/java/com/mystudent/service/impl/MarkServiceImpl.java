/**
 * 
 */
package com.mystudent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudent.model.Mark;
import com.mystudent.model.MarkKey;
import com.mystudent.repository.MarkReopository;
import com.mystudent.service.MarkService;

/**
 * @author Phuc Tran
 *
 */

@Service
public class MarkServiceImpl implements MarkService {

	private MarkReopository repository;
	
	@Autowired
	public MarkServiceImpl(MarkReopository reopository) {
		this.repository = reopository;
	}
	
	public void save(Mark mark) {
		repository.save(mark);
	}
	
	public Iterable<Mark> getAll() {
		return repository.findAll();
	}

//	public List<String> getTop() {
//		return repository.;
//	}

	public Mark getOne(MarkKey id) {
		return repository.getOne(id);
	}

}
