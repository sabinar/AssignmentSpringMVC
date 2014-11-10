package com.example.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.example.model.Person;
import com.example.service.PersonService;
import com.example.service.PersonServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testapplicationContext.xml")
public class PersonServiceImplTest {
	
	@Autowired
	private PersonService personService;

	
	/*public void addPerson(String name, String email) {
		PersonService ps = new PersonServiceImpl();
		Person p = new Person();
		p.setName(name);
		p.setEmail(email);
		ps.addPerson(p);
	}
	
	@Before
	public void addPeople() {
		addPerson("sabina", "asd@SD.sds");
		addPerson("reena", "sdfds@sdfs.csdf");
		addPerson("Rdsds", "email@sd.com");
	}*/
	
	@Test
	public void testListPeople() {
		//PersonService ps = new PersonServiceImpl();
		//assertEquals(3, ps.listPeople().size());
		
	}

}
