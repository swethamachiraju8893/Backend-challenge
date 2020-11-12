package com.example.demo.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.db.entity.Enrollee;

@Repository
public interface EnrolleeRepository extends JpaRepository<Enrollee, Long>{

	Enrollee fetchById(Long id);
	
	List<Enrollee> fetchAll();
	
	
}
