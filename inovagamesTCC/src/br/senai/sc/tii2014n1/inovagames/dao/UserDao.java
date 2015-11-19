package br.senai.sc.tii2014n1.inovagames.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.User;


public class UserDao extends DAO{

	private final String SELECT_EMAIL = "SELECT * FROM user WHERE email = ?";	
	
	private User parseUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setSenha(rs.getString("senha"));
		return user;
	}
	
	public User buscarPorEmail(String email){
		try {
			PreparedStatement ps;
			ps = getConnection().prepareStatement(SELECT_EMAIL);
			ps.setString(1, email);
			ResultSet rs;
			rs = ps.executeQuery();
			if (rs.next()) {
				return parseUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
