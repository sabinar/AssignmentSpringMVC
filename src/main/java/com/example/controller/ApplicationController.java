package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Application;
import com.example.model.Device;
import com.example.service.ApplicationService;
import com.example.service.DeviceService;

@Controller
@RequestMapping("/application")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping("/")
    public String list(Map<String, Object> map) {
    	
    	map.put("application", new Application());
        map.put("applicationList", applicationService.list());
        return "application";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addApplication(@ModelAttribute("application") Application application, BindingResult result) {

        applicationService.add(application);
        return "redirect:/people/application/";
    }

    @RequestMapping("/delete/{appId}")
    public String deleteApplication(@PathVariable("appId") Integer appId) {

        applicationService.delete(appId);
        return "redirect:/people/application/";
    }
    
    @RequestMapping(value = "/addDevice/{appId}", method = RequestMethod.GET)
    public String addDevice(@PathVariable("appId") Integer appId, Map<String, Object> map) {
    	
    	map.put("appDetails" , applicationService.getApp(appId));
    	map.put("deviceListing", deviceService.listDevice());
    	
    	return "addDeviceToApp";
    }
    
    @RequestMapping(value = "/addDevice/{appId}", method = RequestMethod.POST)
    public void updateAppWithDevice(@ModelAttribute("application") Application application,
    		@ModelAttribute("device") Device device,
    		BindingResult result) {
    	
    	System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>inside post method");
    	//return "addDeviceToApp";
    }
	
}
