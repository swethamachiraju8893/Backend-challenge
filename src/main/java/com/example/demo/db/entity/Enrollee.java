 package com.example.demo.db.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
 public class Enrollee {
	@Id
	@GeneratedValue
	private Long Id;
	private String name;
	@Column(name="ACTIVATION_STATUS")
	private boolean status;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	private String PhoneNumber;
	@OneToMany(mappedBy="enrollee", cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Dependent> dependents;

	public Enrollee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enrollee( String name, Date birthDate, String phoneNumber) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		PhoneNumber = phoneNumber;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Set<Dependent> getDependents() {
		return dependents;
	}
	public void setDependents(Set<Dependent> dependents) {
		this.dependents = dependents;
	}

	
}
