package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.entity.Enrollee;
import com.example.demo.service.EnrolleeService;

@RestController
public class EnrolleeController {

	@Autowired
	EnrolleeService service; 
	
	@PostMapping(value="/addNew/enrollee")
	public Enrollee createNewEnrollee(@RequestBody Enrollee enrollee) {
		return service.addNewEnrollee(enrollee);
	}

	@GetMapping(value="/enrollees")
	public List<Enrollee>  listOfEnrollees(){
		List<Enrollee> enrolleeList = service.fetchAllEnrollees();
		return enrolleeList;
	}
	
	@GetMapping(value="/enrolleeDetails/{id}")
	public Enrollee enrolleeDetails(@PathVariable("id") Long id) {
		Enrollee enrollee = service.fetchEnrolleeDetails(id);
		return enrollee;
	}
}
