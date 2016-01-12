package br.senai.sc.tii2014n1.inovagames.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.User;


public class UserDao extends DAO{
	private final String INSERT = "INSERT INTO user (nome, email, cpf, senha, tipoAcesso) VALUES (?,?,?,?, ?)";
	private final String SELECT_EMAIL = "SELECT * FROM user WHERE email = ?";	
	private final String SELECT_ACESSO = "SELECT * FROM user WHERE tipoAcesso = master";
	private final String SELECT = "SELECT * FROM user";
	
	
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
	
	public List<User> listarTodos() {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT);
			ResultSet rs = null;
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setNome(rs.getString("Nome"));
				user.setEmail(rs.getString("email"));
				user.setCpf(rs.getString("cpf"));
				user.setTipoAcesso(rs.getString("tipoAcesso"));
				user.setId(rs.getInt("id"));
				users.add(user);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o select do Produto: " + ex);
		} finally {
			getConnection();
		}
		return users;
	}
	

}
