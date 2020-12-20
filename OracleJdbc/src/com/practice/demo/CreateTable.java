package com.practice.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "123456");
		Statement statement = connection.createStatement();
		String query = "create table emp(id number(10),name varchar2(40),age number(3))";
		statement.execute(query);
		statement.close();
		connection.close();
		System.out.println("table crated successsfully");
	}
}
