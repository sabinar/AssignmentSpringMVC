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

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;
    
    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/")
    public String listPeople(Map<String, Object> map) {

        map.put("person", new Person());
        map.put("peopleList", personService.listPeople());
        
        System.err.println("Hello, logs!");
        map.put("deviceList", personService.getDevicesByUser(35));
        //map.put("deviceList", personService.getPerson(15));

        return "people";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person, BindingResult result) {

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
    	
    	//map.put("deviceList", deviceService.getDevicesByUser(personId));
    	map.put("deviceList", personService.getDevicesByUser(personId));
    	
    	return "redirect:/deviceList";
    }
}
