package com.example.service;

import java.util.List;

import com.example.model.Device;

public interface DeviceService {
	public void addDevice(Device device);
    public List<Device> listDevice();
    public void removeDevice(Integer id);
}
