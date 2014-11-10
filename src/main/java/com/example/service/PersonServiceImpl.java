package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Device;
import com.example.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import java.util.List;

/**
 * Service Implementation class for Person model 
 * @author sabina
 *
 */
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
    	System.err.println("Method to list users/persons");
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
    	System.err.println("List devices by user:" + userId);
    	Person p = getPerson(userId);
    	if (p != null) {
	    	String str1 = "from Device as d where d.person.userId= " + p.getUserId();
	    	System.err.println("--> Query >" + str1);
	    	return (List<Device>)em.createQuery(str1).getResultList();
    	}
    	return null;
    }
}
