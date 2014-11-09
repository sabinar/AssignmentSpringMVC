package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Device {

	@Id
	@GeneratedValue
	private Integer deviceId;
	
	@NotEmpty
	@Pattern(regexp="[\\d]{10}")
	private String phoneNumber;
	
	@NotEmpty
	private String operatingSystem;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn(name="userId")
	private Person person;

	@ManyToMany ( mappedBy = "devices")
	private List<Application> applications = new ArrayList<Application>();
	

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId; 
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}


	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
	@Override
	public boolean equals(Object otherDevice) {
		if (this == otherDevice)
			return true;
		if (!(otherDevice instanceof Device))
			return false;
		Device device = (Device) otherDevice;
		if (!device.getDeviceId().equals(this.getDeviceId()))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 123;
		result = result * ((this.getDeviceId() != null) ? this.getDeviceId().hashCode(): 1);
		return result;
	}
	
}
