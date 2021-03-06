package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Device;
import com.example.model.Person;
import com.example.service.DeviceService;
import com.example.service.PersonService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Controller class for person
 * @author sabina
 *
 */
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
    
    @RequestMapping(value = "/addDevices/{personId}", method = RequestMethod.GET)
    public String addDevicesByUser(@PathVariable("personId") Integer personId, Map<String, Object> map) {
    	
    	if (map.containsKey("deviceDetailsResult")) {
            map.put("org.springframework.validation.BindingResult.deviceDetails",
                    map.get("deviceDetailsResult"));
            System.err.println(map.containsKey("deviceDetails"));
        }
    	else {
    		map.put("deviceDetails", new Device());
    	}
    	
    	map.put("personDetails", personService.getPerson(personId));
    	
    	return "addDeviceToUser";
    }
    
    @RequestMapping(value = "/addDevices/addDeviceToUser/{personId}", method = RequestMethod.POST)
    public String addDeviceToUser(@Valid @ModelAttribute("deviceDetails") Device device, 
    		BindingResult result,
    		@PathVariable("personId") Integer personId,
    		final RedirectAttributes redirectAttributes) {
    	
    	System.err.println("Method use for adding device to user " + personId);
    	Person person = personService.getPerson(personId);
    	if (result.hasErrors()) {
    		System.err.println(">>> There are some errors " + result.getErrorCount());
    		// Redirecting the errors to the next page
    		redirectAttributes.addFlashAttribute("deviceDetailsResult", result);
            redirectAttributes.addFlashAttribute("deviceDetails", device);
    		return "redirect:/people/addDevices/" + personId;
		}
    	device.setPerson(person);
    	deviceService.addDevice(device);
        return "redirect:/people/";
    }
   
    // Method to handle exception in case user trying to delete user which has devices
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errors", exception);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
    
    @RequestMapping("/deviceListPage")
    public String redirectToDeviceList() {
    	return "redirect:/people/device/";
    }
    
    @RequestMapping("/appListPage")
    public String redirectToApplicationList() {
    	return "redirect:/people/application/";
    }
    
    @RequestMapping("/addDevices/{personId}")
    public String addDevicesToUser(@PathVariable("personId") Integer personId) {
    	return "redirect:/device/addDevices/" + personId;
    }
    
    @RequestMapping("/addDevices/backToUserListing")
    public String redirectToUserListing() {
    	return "redirect:/people/";
    }
}
