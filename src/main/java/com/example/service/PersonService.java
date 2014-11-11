package com.example.service;

import java.util.List;

import com.example.model.Device;
import com.example.model.Person;

/**
 * Interface of Device model
 * @author sabina
 *
 */
public interface PersonService {
    public void addPerson(Person person);
    public List<Person> listPeople();
    public void removePerson(Integer id);
    public Person getPerson(Integer userId);
    public List<Device> getDevicesByUser(Integer userId);
}
