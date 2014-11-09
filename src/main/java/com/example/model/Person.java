package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Integer userId;

    @NotEmpty(message = "Please enter name")
    private String name;
    
    @NotEmpty(message = "Please enter email")
    @Email(message = "Please enter valid email")
    private String email;
    
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn (name = "deviceId")
    private List<Device> devices; 

    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
}
