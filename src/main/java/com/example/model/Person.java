package com.example.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;
    
    private String email;
    
//    @OneToMany
//    @JoinColumn (name = "deviceId")
//    private List<Device> devices;

    
public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public List<Device> getDevices() {
//		return devices;
//	}
//
//	public void setDevices(List<Device> devices) {
//		this.devices = devices;
//	}
}
