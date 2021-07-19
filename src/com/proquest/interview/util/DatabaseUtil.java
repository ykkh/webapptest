package com.proquest.interview.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * This class is just a utility class, you should not have to change anything
 * here
 * 
 * @author rconklin
 */
public class DatabaseUtil {

	public static void initDB() {
		try {
			Connection cn = getConnection();
			Statement stmt = cn.createStatement();

			stmt.execute(
					"CREATE TABLE IF NOT EXISTS PHONEBOOK (NAME varchar(255), PHONENUMBER varchar(255), ADDRESS varchar(255))");
			stmt.execute(
					"INSERT INTO PHONEBOOK (NAME, PHONENUMBER, ADDRESS) VALUES('Chris Johnson','(321) 231-7876', '452 Freeman Drive, Algonac, MI')");
			stmt.execute(
					"INSERT INTO PHONEBOOK (NAME, PHONENUMBER, ADDRESS) VALUES('Dave Williams','(231) 502-1236', '285 Huron St, Port Austin, MI')");
			cn.commit();
			cn.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:mem:prod", "sa", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static void initTestDB() {
		try {
			Connection cn = getTestConnection();
			Statement stmt = cn.createStatement();

			stmt.execute(
					"CREATE TABLE IF NOT EXISTS PHONEBOOK (NAME varchar(255), PHONENUMBER varchar(255), ADDRESS varchar(255))");
		
			cn.commit();
			cn.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getTestConnection() {
		Connection connection = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:mem:test", "sa", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
