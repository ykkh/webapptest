package com.proquest.interview.phonebook.dao;

import java.util.List;

import com.proquest.interview.phonebook.model.Person;

public interface PhoneBookDao {
	Person find(String name);

	int add(Person person);
	
	List<Person> findAll();
}
