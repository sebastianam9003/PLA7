package com.trifulcas.Hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	
	public static void main(String[] args) {
		String bd = "instituto";
		String jdbcUrl = "jdbc:mysql://localhost:3306/" + bd + "?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "Picard1966";
		
		try{
			System.out.println("Conectado a: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Todo bien....   Circulen.");
		} catch(Exception exc) { exc.printStackTrace();}

	}

}
