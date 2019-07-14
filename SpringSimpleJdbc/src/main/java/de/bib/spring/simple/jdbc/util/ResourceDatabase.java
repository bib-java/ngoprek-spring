package de.bib.spring.simple.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ResourceDatabase {

	private static ResourceDatabase resource = null;
	private Connection connection = null;

	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost/myjavadb";
	private final String user = "root";
	private final String password = "";

	/**
	 * Constructer class with param
	 * 
	 * @param driver   : Class driver dari database.
	 * @param url      : path url database.
	 * @param user     : Username database.
	 * @param password : Password database.
	 */
	public ResourceDatabase() throws Exception {
		Class.forName(driver);
		this.connection = DriverManager.getConnection(url, user, password);
	}

	/**
	 * Constructer class with param
	 * 
	 * @param driver   : Class driver dari database.
	 * @param url      : path url database.
	 * @param user     : Username database.
	 * @param password : Password database.
	 */
	public ResourceDatabase(String driver, String url, String user, String password) throws Exception {
		Class.forName(driver);
		this.connection = DriverManager.getConnection(url, user, password);
	}

	/**
	 * Get Instance Class Database
	 * 
	 * @param driver   : Class driver dari database.
	 * @param url      : path url database.
	 * @param user     : Username database.
	 * @param password : Password database.
	 * @return : getInstance Class
	 * @throws Exception
	 */
	public static ResourceDatabase getInstance(String Driver, String Url, String User, String Password)
			throws Exception {
		if (resource == null) {
			resource = new ResourceDatabase(Driver, Url, User, Password);
		}
		return resource;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
