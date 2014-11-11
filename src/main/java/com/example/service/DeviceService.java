package com.example.service;

import java.util.List;

import com.example.model.Application;
import com.example.model.Device;

/**
 * Interface for Device model
 * @author sabina
 *
 */
public interface DeviceService {
	public void addDevice(Device device);
    public List<Device> listDevice();
    public void removeDevice(Integer id);
    public Device getDevice(Integer deviceId);
    public List<Application> getApplicationsByDevice(Integer deviceId);
}
