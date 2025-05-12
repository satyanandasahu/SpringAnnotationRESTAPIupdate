package com.example.satya.service;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.satya.dao.IPersonDAO;
import com.example.satya.vo.Person;

@Service
@Component
public class PersonService implements IPersonService{
	
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	IPersonDAO personDAO;

	
	/**
	 * @return the personDAO
	 */
	public IPersonDAO getPersonDAO() {
		return personDAO;
	}

	/**
	 * @param personDAO the personDAO to set
	 */
	public void setPersonDAO(IPersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	public List<Person> getPersonList(Map<String, String> searchCriteria) {
		List<Person> personList = personDAO.getPersonByParam(searchCriteria);
		return personList;
	}

	@Override
	public Person getPerson(Person person) {
		logger.info("Entered Service Method getpersonbyid");
		Person personObject = personDAO.getPersonById(person.getPersonId());
		logger.info("Exited Service Method getpersonby id");
		return personObject;
	}

	@Override
	public Person createPerson(Person person) {
		logger.info("Entered Service Method create");
		personDAO.save(person);
		logger.info("Exited Service Method creat");
		return person;
	}

	@Override
	public Person deletePerson(Person person) {
		personDAO.delete(person);
		return person;
	}

	@Override
	public Person update(Person person) {
		Person personObject = personDAO.update(person);
		return personObject;
	}

}
