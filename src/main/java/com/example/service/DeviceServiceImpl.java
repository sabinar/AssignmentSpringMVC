package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Device;

@Service
public class DeviceServiceImpl implements DeviceService{
	
	@PersistenceContext
    EntityManager em;

	@Transactional
	public void addDevice(Device device) {
		em.persist(device);		
	}

	@Transactional
	public List<Device> listDevice() {
		CriteriaQuery<Device> c = em.getCriteriaBuilder().createQuery(Device.class);
        c.from(Device.class);
        return em.createQuery(c).getResultList();
	}

	@Transactional
	public void removeDevice(Integer id) {
		Device device = em.find(Device.class, id);
        if (null != device) {
            em.remove(device);
        }
	}
}
