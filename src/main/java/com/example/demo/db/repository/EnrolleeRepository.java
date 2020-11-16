package com.example.demo.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.db.entity.Enrollee;

@Repository
public interface EnrolleeRepository extends JpaRepository<Enrollee, Long>{

	Optional<Enrollee> findById(Long id);
	
	List<Enrollee> findAll();
	
	
}
