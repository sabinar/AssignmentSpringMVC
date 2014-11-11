package com.example.service;

import java.util.List;

import com.example.model.Application;

/**
 * Interface for Application model
 * @author sabina
 *
 */
public interface ApplicationService {

	public void add(Application application);
	public List<Application> list();
	public void delete(Integer appId);
	public Application getApp(Integer appId);
	// Method used to save modifications of Application model
	public void save(Application application); 
	
}
