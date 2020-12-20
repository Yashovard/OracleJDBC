package com.practice.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Crud {
	Connection connection;
	Scanner scanner;
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "123456");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void createTable() throws Exception {
		Statement statement = connection.createStatement();
		String query = "create table Teacher(id number(10),name varchar2(40),address varchar2(80),emailId varchar2(50),number varchar2(15),password varchar2(20),salary varchar2(10)";
		statement.execute(query);
		statement.close();
		connection.close();
		System.out.println("table crated successsfully");

	}

	public void insert() throws ClassNotFoundException, SQLException {
		String sql = "insert into Teacher values(?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("enter the id");
			int tid = sc.nextInt();
			System.out.println("enter the your name insert");
			String name = sc.next();
			System.out.println("enter your address");
			String address = sc.next();
			System.out.println("enter emailId");
			String emailId = sc.next();
			System.out.println("enter the number");
			String contactNO = sc.next();
			System.out.println("enter the password");
			String password = sc.next();
			System.out.println("enter the salary");
			String salary = sc.next();
			ps.setLong(1, tid);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, emailId);
			ps.setString(5, contactNO);
			ps.setString(6, password);
			ps.setString(7, salary);
			ps.executeUpdate();
			System.out.println("Record insert successfully");
			System.out.println("Do you want to add more recoord Yes/No");
			String option = sc.next();
			if (option.equalsIgnoreCase("No")) {
				break;
			} else {
				continue;
			}
		}
		connection.close();
	}

	public void delete() throws ClassNotFoundException, SQLException {
		scanner = new Scanner(System.in);
		System.out.println("enter the id you want to delete");
		int id = scanner.nextInt();
		Statement st = connection.createStatement();
		String query = "delete from teacher where tid=" + id;
		st.execute(query);
		st.close();
		connection.close();
		System.out.println("data deleted....");
	}

	public void fetch() throws SQLException {
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from teacher");
		while (rs.next())
			System.out.println(rs.getInt(1) + " ! " + rs.getString(2) + " ! " + rs.getString(3) + " ! "
					+ rs.getString(4) + " ! " + rs.getString(5) + " ! " + rs.getString(6) + " ! " + rs.getString(7));
		connection.close();
	}

	public void update() throws SQLException {
		scanner = new Scanner(System.in);
		Statement st = connection.createStatement();
		System.out.println("enter id you want to update");
		int id = scanner.nextInt();
		System.out.println("enter the name");
		String name = scanner.next();
		String query = "UPDATE teacher SET tname='" + name + "' WHERE tid=" + id;
		st.execute(query);
		st.close();
		connection.close();
		System.out.println("data Updated....");
	}

	public static void main(String[] args) throws Exception {
		Crud crud = new Crud();
		Scanner scanner = new Scanner(System.in);
		crud.createTable();
		/*
		 * System.out.println("********Hello Teacher***************");
		 * System.out.println("press A for Insert data");
		 * System.out.println("press B for Delete data");
		 * System.out.println("press C for Fetch Table data");
		 * System.out.println("press D for update Table data");
		 */
		String a = scanner.next();
		if (a.equalsIgnoreCase("a")) {
			crud.insert();
		} else if (a.equalsIgnoreCase("b")) {
			crud.delete();
		} else if (a.equalsIgnoreCase("c")) {
			crud.fetch();
		} else if (a.equalsIgnoreCase("d")) {
			crud.update();
		} else {
			System.out.println("Please select any option");

		}
	}
}
