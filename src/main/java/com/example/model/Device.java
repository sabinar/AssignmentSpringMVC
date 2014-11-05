package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Device {

	@Id
	@GeneratedValue
	@Column(name = "DEVICE_ID")
	private Integer id;
	
	private Integer phoneNumber;
	
	private Integer operatingSystem;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Person person;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(Integer operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}
