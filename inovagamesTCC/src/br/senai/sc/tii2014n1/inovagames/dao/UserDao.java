package br.senai.sc.tii2014n1.inovagames.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Produto;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.User;


public class UserDao extends DAO{
	private final String INSERT = "INSERT INTO user (nome, email, cpf, senha, tipoAcesso) VALUES (?,?,?,?, ?)";
	private final String SELECT_EMAIL = "SELECT * FROM user WHERE email = ?";	
	private final String SELECT_ACESSO = "SELECT * FROM user WHERE tipoAcesso = master";
	
	private User parseUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setSenha(rs.getString("senha"));
		user.setTipoAcesso(rs.getString("tipoAcesso"));
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
	
	public User buscarPorTipoAcesso(String tipoAcesso){
		try {
			PreparedStatement ps;
			ps = getConnection().prepareStatement(SELECT_ACESSO);
			ps.setString(1, tipoAcesso);
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
	
	public void salvar(User user) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCpf());
			ps.setString(4, user.getSenha());
			ps.setString(5, user.getTipoAcesso());
			ps.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("Erro ao executar o insert: " + ex);
		} finally {
			getConnection();
		}
	}
}
