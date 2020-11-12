package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.entity.Enrollee;
import com.example.demo.db.repository.EnrolleeRepository;
import com.example.demo.service.EnrolleeService;

@RestController
public class EnrolleeController {

	@Autowired
	EnrolleeService service; 
	
//	@PostMapping(value="/addNew/enrollee")
//	public String createNewEnrollee(@RequestParam("id") Long id) {
//		
//	}
//	
	@GetMapping(value="/getEnrollees")
	public List<Enrollee>  listOfEnrollees(){
		List<Enrollee> enrolleeList = service.fetchAllEnrollees();
		return enrolleeList;
	}
	
	@GetMapping(value="/getEnrolleeDetails")
	public Enrollee enrolleeDetails(@PathVariable("id") Long id) {
		Enrollee enrollee = service.fetchEnrolleeDetails(id);
		return enrollee;
	}
}
