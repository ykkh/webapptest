package com.proquest.interview.phonebook.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proquest.interview.phonebook.model.Person;
import com.proquest.interview.util.DatabaseUtil;

public class PhoneBookDaoImpl implements PhoneBookDao {

	@Override
	public Person find(String name) {

		Person person = null;
		Connection cn = DatabaseUtil.getConnection();
		Statement stmt = null;
		ResultSet set = null;
		try {
			stmt = cn.createStatement();
			set = stmt.executeQuery("SELECT * FROM PHONEBOOK WHERE NAME = '" + name + "'");

			stmt.closeOnCompletion();

			while (set.next()) {
				person = new Person(set.getString("NAME"), set.getString("PHONENUMBER"), set.getString("ADDRESS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cn.commit();
				cn.close();
				stmt.closeOnCompletion();
				set.close();
			} catch (Exception e) {
				/** Ignored */
			}
		}
		return person;
	}

	@Override
	public int add(Person person) {
		int result = 0;
		Connection cn = DatabaseUtil.getConnection();
		Statement stmt = null;
		try {
			stmt = cn.createStatement();
		 result =	stmt.executeUpdate("INSERT INTO PHONEBOOK (NAME, PHONENUMBER, ADDRESS) VALUES('" + person.getName() + "','"
					+ person.getPhoneNumber() + "', '" + person.getAddress() + "')");
			cn.commit();
			cn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cn.commit();
				cn.close();
				stmt.closeOnCompletion();
			} catch (Exception e) {
				/** Ignored */
			}

		}
		return result;
	}

	@Override
	public List<Person> findAll() {
		List<Person> people = new ArrayList<Person>();
		Connection cn = DatabaseUtil.getConnection();
		Statement stmt = null;
		ResultSet set = null;
		try {
			stmt = cn.createStatement();
			set = stmt.executeQuery("SELECT * FROM PHONEBOOK");

			stmt.closeOnCompletion();

			while (set.next()) {
				Person person = new Person(set.getString("NAME"), set.getString("PHONENUMBER"),
						set.getString("ADDRESS"));
				people.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cn.commit();
				cn.close();
				stmt.closeOnCompletion();
				set.close();
			} catch (Exception e) {
				/** Ignored */
			}
		}
		return people;
	}
}
