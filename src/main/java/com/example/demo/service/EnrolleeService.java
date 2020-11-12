package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db.entity.Enrollee;
import com.example.demo.db.repository.EnrolleeRepository;

@Service
public class EnrolleeService {
	
	@Autowired
	EnrolleeRepository repo;
	
	public List<Enrollee> fetchAllEnrollees(){
		return repo.fetchAll();
	}
	
	public Enrollee fetchEnrolleeDetails(Long id) {
		Enrollee enrollee= repo.fetchById(id);
		return enrollee;
	}
}
