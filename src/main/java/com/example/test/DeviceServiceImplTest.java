package com.example.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.Device;
import com.example.model.Person;
import com.example.service.DeviceService;
import com.example.service.PersonService;

/**
 * Test cases for DeviceServiceImpl.java
 * @author sabina
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testInMemoryContext.xml"})
public class DeviceServiceImplTest {
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private PersonService personService;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Before
	public void preConditions() {
		Person person = new Person();
		person.setName("John Doe");
		person.setEmail("johndoe@email.com");
		personService.addPerson(person);
	}
	
	@Test
	public void testAddDevice() {
		Device device = addDevice("9008035182", "Android");
		deviceService.addDevice(device);
		assertNotNull(device.getDeviceId());
	}
	
	@Test
	public void listDevice() {
		Device device = addDevice("1208035182", "IOS");
		deviceService.addDevice(device);
		assertEquals(1, deviceService.listDevice().size());
	}
	
	@Test
	public void testGetDevice() {
		Device device1 = addDevice("5454545454", "IOS");
		deviceService.addDevice(device1);
		Device device2 = deviceService.getDevice(device1.getDeviceId());
		assertEquals(device2.getPhoneNumber(), device1.getPhoneNumber());
		assertEquals(device2.getOperatingSystem(), device1.getOperatingSystem());
	}
	
	@Test
	public void testRemoveDevice() {
		Device d1 = addDevice("3344556677", "operatingSystem");
		d1.setPerson(personService.getPerson(1));
		deviceService.addDevice(d1);
		assertEquals("After adding device", 1, deviceService.listDevice().size());
		deviceService.removeDevice(d1.getDeviceId());
		assertEquals("After deleting device", 0, deviceService.listDevice().size());
	}
	
	@Test
	public void getDeviceByUser() {
		Device d1 = addDevice("3344556677", "operatingSystem");
		d1.setPerson(personService.getPerson(1));
		deviceService.addDevice(d1);
		List<Device> deviceList = personService.getDevicesByUser(1);
		assertEquals(1, deviceList.size());
	}
	
	public Device addDevice(String phoneNumber, String operatingSystem) {
		Device device = new Device();
		device.setPhoneNumber(phoneNumber);
		device.setOperatingSystem(operatingSystem);
		return device;
	}
}
