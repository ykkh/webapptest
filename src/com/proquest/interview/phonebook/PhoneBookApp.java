package com.proquest.interview.phonebook;

import com.proquest.interview.phonebook.model.Person;
import com.proquest.interview.phonebook.service.PhoneBook;
import com.proquest.interview.phonebook.service.PhoneBookImpl;
import com.proquest.interview.util.DatabaseUtil;

public class PhoneBookApp {
	public static void main(String[] args) {
		DatabaseUtil.initDB(); // You should not remove this line, it creates the in-memory database

		PhoneBook phoneBookService = new PhoneBookImpl();
		//insert new Person object into db
		phoneBookService.addPerson(new Person("John Smith", "(248) 123-4567", "1234 Sand Hill Dr, Royal Oak, MI")); 
		phoneBookService.addPerson(new Person("Cynthia Smith", " (824) 128-8758", "875 Main St, Ann Arbor, MI")); 
		
		Person p = phoneBookService.findPerson("Cynthia", "Smith"); //find person from db by Name
		System.out.println("Database Serarch Result for Cynthia Smith: ");
		System.out.println(p);
		System.out.println("***********************");
		System.out.println("Printing the whole phone book from database");
		for(Person per: phoneBookService.getAllPhoneBook()) {  //find all person from phonebook db
			System.out.println(per);
		}

	}
}
