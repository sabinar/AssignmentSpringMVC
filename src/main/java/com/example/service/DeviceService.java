package com.example.service;

import java.util.List;

import com.example.model.Application;
import com.example.model.Device;

public interface DeviceService {
	public void addDevice(Device device);
    public List<Device> listDevice();
    public void removeDevice(Integer id);
    
    //public List<Device> getDevicesByUser(Integer userId);
    
    public List<Application> getApplicationsByDevice(Integer deviceId);
}
