package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Device;
import com.example.service.DeviceService;

import java.util.Map;

import javax.validation.Valid;

/**
 * Controller class for Device model
 * @author sabina
 *
 */
@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;
    
    @RequestMapping("/")
    public String listDevice(Map<String, Object> map) {
    	map.put("device", new Device());
        map.put("deviceList", deviceService.listDevice());
        return "device";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDevice(@Valid @ModelAttribute("device") Device device, BindingResult result, Map<String, Object> map) {
    	if (result.hasErrors()) {
    		map.put("deviceList", deviceService.listDevice());
			return "device";
		}
        deviceService.addDevice(device);
        return "redirect:/people/device/";
    }

    @RequestMapping("/delete/{deviceId}")
    public String deleteDevice(@PathVariable("deviceId") Integer deviceId) {
        deviceService.removeDevice(deviceId);
        return "redirect:/people/device/";
    }
    
    @RequestMapping(value = "/getApplications/{deviceId}", method = RequestMethod.GET)
    public String getApplications(@PathVariable("deviceId") Integer deviceId, Map<String, Object> map) {
    	Device deviceDetails = deviceService.getDevice(deviceId);
    	map.put("deviceDetails", deviceDetails);
    	map.put("applicationList", deviceService.getApplicationsByDevice(deviceId));
    	return "appListPerDevice";
    }
    
    @RequestMapping("/people")
    public String redirectToUserPage() {
    	return "redirect:/people/";
    }
    
    @RequestMapping("/getApplications/backToDeviceList")
    public String redirectToDeviceList() {
    	return "redirect:/people/device/";
    }
    
    @RequestMapping("/appListPage")
    public String redirectToApplicationList() {
    	return "redirect:/people/application/";
    }
}
