package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
    	
    	System.err.println(">>> Inside add user of controller");
    	if (result.hasErrors()) {
    		System.err.println("Some error message to come");
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
}
