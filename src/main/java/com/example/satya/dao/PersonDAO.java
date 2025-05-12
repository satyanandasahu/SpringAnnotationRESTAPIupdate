package com.example.satya.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.satya.vo.Person;

@EnableTransactionManagement
@Repository
@Component
public class PersonDAO implements IPersonDAO {

	private static Logger logger = LogManager.getLogger();

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 *//*
		 * public SessionFactory getSessionFactory() { return sessionFactory; }
		 */

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */

	private Session getSession() {
		logger.info("Getting Session");
		Session session = this.sessionFactory.openSession();
		logger.info("Got Session Object");
		return session;
	}

	public void save(Person person) {
		logger.info("Entered save");
		Session session = getSession();
		session.beginTransaction();
		session.persist(person);
		session.getTransaction().commit();
		logger.info("Entered save");
	}

	public List<Person> retriveAll() {
		logger.info("Entered retrieveAll");
		List<Person> list = getSession().createQuery("from Person", Person.class).list();
		logger.info("Exit retrieveAll");
		return list;
	}

	public Person getPersonById(String id) {
		logger.info("Entered getPersonById");
		Person person = null;
		person = getSession().get(Person.class, id);
		logger.info("Person " + person);
		logger.info("Exited getPersonById");
		return person;
	}

	public List<Person> getPersonByParam(Map<String, String> searchCriteria) {

		logger.info("Entered getPersonByParam");
		List<Person> personObject = null;
		StringBuilder queryString = new StringBuilder(" where ");
		boolean andFlag = false;
		for (Map.Entry<String, String> entry : searchCriteria.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (andFlag) {
				queryString.append(" and ").append(key).append(" = ").append("'").append(value).append("' ");
			} else {
				queryString.append(key).append(" = ").append("'").append(value).append("' ");
				andFlag = true;
			}
		}

		/*
		 * if (searchCriteria.get(QueryConstants.PERSON_AGE) != null) { String age =
		 * searchCriteria.get(QueryConstants.PERSON_AGE); if (!age.isBlank() &&
		 * !age.isEmpty())
		 * queryString.append(" and ").append("age").append(" = ").append("40"); }
		 */

		logger.info("Query String ======> " + queryString);

		personObject = getSession().createQuery("from Person " + queryString.toString(), Person.class).list();

		logger.info("Exit getPersonByParam: " + personObject);
		return personObject;
	}

	public Person update(Person person) {
		logger.info("Entered update");
		Session session = getSession();
		Person personObject = null;
		Person returnedObject = null;
		session.beginTransaction();
		personObject = session.get(Person.class, person.getPersonId());
		logger.debug("Fetched Person from database/Object before update " + personObject);
		personObject
				.setFirstName(person.getFirstName() != null && !person.getFirstName().isEmpty() ? person.getFirstName()
						: personObject.getFirstName());
		personObject.setLastName(person.getLastName() != null && !person.getLastName().isEmpty() ? person.getLastName()
				: personObject.getLastName());
		personObject.setMiddleName(
				person.getMiddleName() != null && !person.getMiddleName().isEmpty() ? person.getMiddleName()
						: personObject.getMiddleName());
		personObject.setAge(person.getAge() != 0 ? person.getAge() : personObject.getAge());
		personObject.setGender(person.getGender() != null && !person.getGender().isEmpty() ? person.getGender()
				: personObject.getGender());
		logger.info("Updating Person " + personObject);
		returnedObject = session.merge(personObject);
		session.getTransaction().commit();
		if (returnedObject.getPersonId().equals(personObject.getPersonId()))
			logger.info("Record updated: " + returnedObject);
		else
			logger.info("Record update failed");
		logger.info("Exit update");
		return returnedObject;
	}

	public void delete(Person person) {
		logger.info("Entered delete");
		Session session = getSession();
		session.beginTransaction();
		session.remove(person);
		session.getTransaction().commit();
		logger.info("deleted person id: " + person.getPersonId());
	}

}
