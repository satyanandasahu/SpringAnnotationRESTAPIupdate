package com.example.satya.service;

import java.util.List;
import java.util.Map;

import com.example.satya.vo.Person;

public interface IPersonService {

	public List<Person> getPersonList(Map<String, String> SearchCriteria);

	public Person getPerson(Person person);

	public Person createPerson(Person person);

	public Person deletePerson(Person person);

	public Person update(Person person);
}
