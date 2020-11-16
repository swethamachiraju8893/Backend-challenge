package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db.entity.Enrollee;
import com.example.demo.db.repository.EnrolleeRepository;

@Service
public class EnrolleeService {
	
	@Autowired
	EnrolleeRepository repo;
	
	public List<Enrollee> fetchAllEnrollees(){
		return repo.findAll();
	}
	
	public Enrollee fetchEnrolleeDetails(Long id) {
		Optional<Enrollee> enrollee= repo.findById(id);
		return enrollee.get();
	}

	public Enrollee addNewEnrollee(Enrollee enrollee) {
		// TODO Auto-generated method stub
		return  repo.save(enrollee);
	}
}
