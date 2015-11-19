package br.senai.sc.tii2014n1.inovagames.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DAO {

	private Connection conn;
	
	public Connection getConnection(){
		
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/inovagamesTCC", "root", "");
				System.out.println("Conectou");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
}
