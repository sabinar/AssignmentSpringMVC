package com.example.service;

//import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Device;
import com.example.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @PersistenceContext
    EntityManager em;
        
    @Transactional
    public void addPerson(Person person) {
        em.persist(person);
    }

    @Transactional
    public List<Person> listPeople() {
        CriteriaQuery<Person> c = em.getCriteriaBuilder().createQuery(Person.class);
        c.from(Person.class);
        return em.createQuery(c).getResultList();
    }

    @Transactional
    public void removePerson(Integer id) {
        Person person = em.find(Person.class, id);
        if (null != person) {
            em.remove(person);
        }
    }
    
    @Transactional
    public Person getPerson(Integer userId) {
    	return em.find(Person.class, userId);
    }
    
    @Transactional
    public List<Device> getDevicesByUser(Integer userId) {
    	System.err.println("Inside get Devices  By user");
    	Person p = getPerson(userId);
    	System.err.println("nnnamm>>"  + p.getFirstName() + ">>" + p.getDevices().size());
    	
    	String str = "select d FROM device d where d.id = " + p.getId();
    	Query query = em.createNativeQuery(str);
    	
    	List<Device> list =  (List<Device>)query.getResultList();
    	 
    	for (Device d : list) {
    		System.err.println("phone>>" +d.getPhoneNumber());
    	}
    	System.err.println("end>>> " + p.getLastName());
    	//return p.getDevices();
    	return list;
    }
}
