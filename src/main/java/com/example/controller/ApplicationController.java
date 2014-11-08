package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;

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
    
    private Map<Integer, Device> deviceCache;
    
    @RequestMapping(value = "/addDevice/{appId}", method = RequestMethod.GET)
    public String addDevice(@PathVariable("appId") Integer appId, Map<String, Object> map) {
    	
    	map.put("appDetails" , applicationService.getApp(appId));
    	//map.put("deviceListing", deviceService.listDevice());
    	
    	List<Device> deviceListing = deviceService.listDevice();
//    	for (Device d : deviceListing) {
//    		if (d != null)
//    			deviceCache.put(d.getDeviceId(), d);    		
//    	}
    	//map.put("deviceListing", deviceCache);
    	map.put("deviceListing", deviceService.listDevice());
    	    	
    	return "addDeviceToApp";
    }
    
   /* @RequestMapping(value = "/updateApp", method = RequestMethod.POST)
    public void updateAppWithDevice(@ModelAttribute("application") Application application,
    		 		BindingResult result, @PathVariable Integer deviceId) {
    	
    	System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>inside post method");
    	//return "addDeviceToApp";
    }*/
    
    /*@RequestMapping(value = "/addDevice/{appId}", method = RequestMethod.POST)
    public void updateAppWithDevice(@ModelAttribute("appDetails") Application application, BindingResult result) {

    	System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>inside post method");
    }*/
	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	binder.registerCustomEditor(List.class, "devices", new CustomCollectionEditor(List.class) {
    		protected Object convertElement(Object element) {
    			System.err.println("Inside binder");
    			if (element instanceof String) {
    				Device device = deviceCache.get(Integer.valueOf(element.toString()));
    				System.err.println("Reached here");
    				//return deviceService.listDevice().get(0);
    				return device;
    			}
    			if (element instanceof Device) {
    				System.err.println("Same eleemnt");
    				return element;
    			}
    			return null;
    		}
    	});
    }
    
    @RequestMapping(value = "/addDevice/mapping", method = RequestMethod.POST)
    public String addDevice(@ModelAttribute("appDetails") Application application, 
    		BindingResult result) {
    	//, @PathVariable Integer categoryId
    	System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>inside post method");
    	System.err.println(application.getAppName() + ">>>" + application.getDevices() + ">>>" );
    	
    	System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>inside post method");
        
        return "redirect:/people/application/";
    }
}
