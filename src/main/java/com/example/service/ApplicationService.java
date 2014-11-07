package com.example.service;

import java.util.List;

import com.example.model.Application;

public interface ApplicationService {

	public void add(Application application);
	public List<Application> list();
	public void delete(Integer appId);
	
	public Application getApp(Integer appId);
	
}
