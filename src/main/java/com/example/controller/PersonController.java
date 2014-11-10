package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Device;
import com.example.model.Person;
import com.example.service.DeviceService;
import com.example.service.PersonService;

import java.util.Map;

import javax.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;
    
    @RequestMapping("/")
    public String listPeople(Map<String, Object> map) {
        map.put("person", new Person());
        map.put("peopleList", personService.listPeople());
        return "people";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, Map<String, Object> map) {
    	
    	if (result.hasErrors()) {
    		map.put("peopleList", personService.listPeople());
			return "people";
		}
        personService.addPerson(person);
        return "redirect:/people/";
    }

    @RequestMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Integer personId) {

        personService.removePerson(personId);

        return "redirect:/people/";
    }
    
    @RequestMapping("/getDevices/{personId}")
    public String getDevicesByUser(@PathVariable("personId") Integer personId, Map<String, Object> map) {
    	
    	map.put("personDetails", personService.getPerson(personId));
    	map.put("deviceList", personService.getDevicesByUser(personId));
    	
    	return "deviceList";
    }
    
    @RequestMapping("/deviceListPage")
    public String redirectToDeviceList() {
    	return "redirect:/people/device/";
    }
    
    @RequestMapping("/appListPage")
    public String redirectToApplicationList() {
    	return "redirect:/people/application/";
    }
    
    
    @RequestMapping("/addDevices/backToUserListing")
    public String redirectToUserListing() {
    	return "redirect:/people/";
    }
    
    @RequestMapping(value = "/addDevices/{personId}", method = RequestMethod.GET)
    public String addDevicesByUser(@PathVariable("personId") Integer personId, Map<String, Object> map) {
    	
    	map.put("personDetails", personService.getPerson(personId));
    	map.put("deviceDetails", new Device());
    	
    	return "addDeviceToUser";
    }
    
    
    @RequestMapping(value = "/addDevices/addDeviceToUser/{personId}", method = RequestMethod.POST)
    public String addDeviceToUser(@Valid @ModelAttribute("deviceDetails") Device device, 
    		BindingResult result,
    		@PathVariable("personId") Integer personId,
    		Map<String, Object> map) {
    	
    	System.err.println("adding device to user " + personId);
    	if (result.hasErrors()) {
    		map.put("personDetails", personService.getPerson(personId));
        	map.put("deviceDetails", new Device());
    		return "addDeviceToUser";
		}
        //personService.addPerson(person);
        return "redirect:/people/";
    }
    
    
}
