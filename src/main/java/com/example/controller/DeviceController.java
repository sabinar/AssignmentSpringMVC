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

        map.put("device", new Device());
        map.put("deviceList", deviceService.listDevice());

        return "redirect:/people/device/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDevice(@ModelAttribute("Device") Device Device, BindingResult result) {

        deviceService.addDevice(Device);

        return "redirect:/device/";
    }

    @RequestMapping("/delete/{DeviceId}")
    public String deleteDevice(@PathVariable("DeviceId") Integer DeviceId) {

        deviceService.removeDevice(DeviceId);

        return "redirect:/device/";
    }
}
