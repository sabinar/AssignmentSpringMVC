package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Application;
import com.example.model.Device;
import com.example.model.Person;

@Service
public class DeviceServiceImpl implements DeviceService{
	
	@PersistenceContext
    EntityManager em;

	@Override
	@Transactional
	public void addDevice(Device device) {
		em.persist(device);		
	}

	@Override
	@Transactional
	public List<Device> listDevice() {
		System.err.println("--> Inside Listing Device");
		CriteriaQuery<Device> c = em.getCriteriaBuilder().createQuery(Device.class);
        c.from(Device.class);
        return em.createQuery(c).getResultList();
	}
	
	@Override
	@Transactional
	public Device getDevice(Integer deviceId) {
		return em.find(Device.class, deviceId);
	}

	@Override
	@Transactional
	public void removeDevice(Integer id) {
		Device device = em.find(Device.class, id);
        if (null != device) {
            em.remove(device);
        }
	}
	
	@Override
	@Transactional
	public List<Application> getApplicationsByDevice(Integer deviceId) {
		Device device = em.find(Device.class, deviceId);
		
		if (device != null) {
			System.err.println("get application from device serr>>" + device.getApplications().size());
			return device.getApplications();
		}
		return null;
	}
}
