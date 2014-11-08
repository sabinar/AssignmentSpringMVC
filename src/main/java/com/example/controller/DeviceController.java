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

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/")
    public String listDevice(Map<String, Object> map) {
    	
    	System.err.println("Hello, logs!");
        map.put("device", new Device());
        map.put("deviceList", deviceService.listDevice());

        return "device";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDevice(@ModelAttribute("device") Device device, BindingResult result) {

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
    	System.err.println(">>>Phone number>>>" + deviceDetails.getPhoneNumber());
    	map.put("deviceDetails", deviceDetails);
    	
    	map.put("applicationList", deviceService.getApplicationsByDevice(deviceId));
    	return "appListPerDevice";
    }
    
    @RequestMapping("/people")
    public String redirectToUserPage() {
    	System.err.println("---> Reached inside device page to redirect to User page");
    	return "redirect:/people/";
    }
    
    @RequestMapping("/getApplications/backToDeviceList")
    public String redirectToDeviceList() {
    	System.err.println("---->>> Back to device list page");
    	
    	return "redirect:/people/device/";
    }
}
