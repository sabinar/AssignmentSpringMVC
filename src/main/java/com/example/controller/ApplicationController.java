package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Application;
import com.example.service.ApplicationService;

@Controller
@RequestMapping("/people/application")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping("/")
    public String list(Map<String, Object> map) {
    	
    	System.err.println("Hello, logs!");
        map.put("application", new Application());
        map.put("applicationList", applicationService.list());

        return "application";
    }
}
