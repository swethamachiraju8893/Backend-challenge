package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.entity.Enrollee;
import com.example.demo.service.EnrolleeService;

@RestController
public class EnrolleeController {

	//final static Logger logger = Logger.getLogger(EnrolleeController.class);

	@Autowired
	EnrolleeService service; 
	
	@PostMapping(value="/addNew/enrollee")
	public ResponseEntity<Enrollee> createNewEnrollee(@RequestBody Enrollee enrollee) {
		return new ResponseEntity<Enrollee>(service.addNewEnrollee(enrollee),HttpStatus.CREATED);
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
	
	@PutMapping(value="/enrollees/{id}")
	public ResponseEntity<Enrollee> modifyEnrollee(@RequestBody Enrollee enrollee, @PathVariable Long id) {
		return new ResponseEntity<Enrollee>(service.modifyExistingEnrollee(enrollee,id),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/enrollees/{id}")
	public ResponseEntity<Void> deleteEnrollee(@PathVariable Long id) {
		Enrollee enrollee = service.fetchEnrolleeDetails(id);
		if (enrollee == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
