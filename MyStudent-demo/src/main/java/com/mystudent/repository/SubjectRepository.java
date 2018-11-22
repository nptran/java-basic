/**
 * 
 */
package com.mystudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudent.model.Subject;

/**
 * @author Phuc Tran
 *
 */
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
