package br.senai.sc.tii2014n1.inovagames.dao;

import java.sql.DriverManager;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.Connection;

public class DAO {

	private Connection conn;
	
	public Connection getConnection(){
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String servidor = externalContext.getInitParameter("servidor");
		String banco = externalContext.getInitParameter("banco");
		String usuario = externalContext.getInitParameter("usuario");
		String senha = externalContext.getInitParameter("senha");
		
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + banco , usuario, senha);
				System.out.println("Conectou");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
}
