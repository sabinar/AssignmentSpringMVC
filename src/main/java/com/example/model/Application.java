package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Class of Application model
 * @author sabina
 *
 */
@Entity
public class Application {

	@Id
	@GeneratedValue
	private Integer appId;
	
	@NotBlank (message = "Please enter application name")
	private String appName;
	
	private String appDesc;
	
	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "device_application", joinColumns = { @JoinColumn(name = "appId") }, inverseJoinColumns = { @JoinColumn(name = "deviceId") })  
    private List<Device> devices = new ArrayList<Device>();

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
}
