package com.example.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.Person;
import com.example.service.PersonService;

/**
 * Test cases for PersonServiceImpl.java
 * @author sabina
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testInMemoryContext.xml"})
public class PersonServiceImplTest {
	
	@Autowired
    PersonService personService;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory ;
	
	@Before
	public void addPersons() {
		Person person1 = addPerson("testA", "test1@email.com");
		personService.addPerson(person1);
		Person person2 = addPerson("testB", "test1@email.com");
		personService.addPerson(person2);
		Person person3 = addPerson("testC", "test1@email.com");
		personService.addPerson(person3);
	}
	
	@Test
	public void testListPeople() {
		assertEquals(5, personService.listPeople().size());
	}

	@Test
	public void testAddPerson() {
		Person person = addPerson("test1", "test@email.com");
		personService.addPerson(person);
		Person p1 = personService.getPerson(person.getUserId());
		assertNotNull(p1);
	}
	
	@Test
	public void testGetPerson() {
		Person person = addPerson("test3", "test3@email.com");
		personService.addPerson(person);
		Person p1 = personService.getPerson(person.getUserId());
		assertEquals(p1.getName(), person.getName());
		assertEquals(p1.getEmail(), person.getEmail());
	}
	
	@Test 
	public void deletePerson() {
		int size = personService.listPeople().size();
		personService.removePerson(1);
		assertEquals(size-1, personService.listPeople().size());
	}
	
	public Person addPerson(String name, String email) {
        Person p = new Person();
        p.setName(name);
        p.setEmail(email);
        return p;
   }

}
