package com.example.satya.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.example.satya.vo.Address;
import com.example.satya.vo.Person;

public class ConvertHibernatePojoToNormalPojo {

	public static Person convertPojo(Person person) {

		Person per = new Person();
		per.setAge(person.getAge());
		per.setFirstName(person.getFirstName());
		per.setLastName(person.getLastName());
		per.setMiddleName(person.getMiddleName());
		per.setGender(person.getGender());
		per.setPersonId(person.getPersonId());

		if (person.getAddress() != null && !person.getAddress().isEmpty()) {
			Set<Address> addrSet = new HashSet<Address>();
			Address addr = null;
			for (Iterator<Address> iterator = person.getAddress().iterator(); iterator.hasNext();) {
				Address address = iterator.next();
				addr = new Address();
				addr.setAddressId(address.getAddressId());
				addr.setPersonId(address.getPerson().getPersonId());
				addr.setAddressLine1(address.getAddressLine1());
				addr.setAddressLine2(address.getAddressLine2());
				addr.setAddressType(address.getAddressType());
				addr.setCity(address.getCity());
				addr.setCountry(address.getCountry());
				addr.setDistrictCounty(address.getDistrictCounty());
				addr.setPinZipcode(address.getPinZipcode());
				addr.setState(address.getState());
				addrSet.add(addr);

			}
			per.setAddress(addrSet);
		}

		return per;
	}

}
