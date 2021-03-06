package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Model object for Device.
 * ManytoOne association with Person
 * ManytoMany association with Applications
 * @author sabina
 *
 */
@Entity
public class Device {

	@Id
	@GeneratedValue
	private Integer deviceId;
	
	@NotEmpty(message = "Please enter phone number")
	@Pattern(regexp="[\\d]{10}", message = "Please enter valid 10 digit phone number")
	private String phoneNumber;
	
	@NotEmpty(message = "Please enter operating System")
	private String operatingSystem;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Person person;

	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "device_application", joinColumns = { @JoinColumn(name = "deviceId") }, inverseJoinColumns = { @JoinColumn(name = "appId") })
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
	
	// Overriding equals and hashCode for displaying devices in application
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
