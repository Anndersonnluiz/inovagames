package br.senai.sc.tii2014n1.inovagames.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Plataforma;

public class PlataformaDao extends DAO {

	private final String INSERT = "INSERT INTO plataforma (plataforma) VALUES (?)";
	private final String UPDATE = "UPDATE plataforma SET plataforma = ? WHERE idPlataforma = ?";
	private final String DELETE = "DELETE FROM plataforma WHERE idPlataforma = ?";
	private final String SELECT = "SELECT * FROM plataforma";
	private final String SELECT_ID = "SELECT * FROM plataforma WHERE idPlataforma = ?";

	
	public void salvar(Plataforma plataforma) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, plataforma.getPlataforma());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o insert: " + ex);
		} finally {
			getConnection();
		}
	}

	
	public void alterar(Plataforma plataforma) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(UPDATE);
			ps.setString(1, plataforma.getPlataforma());
			ps.setLong(2, plataforma.getIdPlataforma());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o update: " + ex);
		} finally {
			getConnection();
		}
	}

	
	public void excluir(Integer id) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(DELETE);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o delete: " + ex);
		} finally {
			getConnection();
		}
	}

	
	public List<Plataforma> listarTodos() {
		List<Plataforma> plataformas = new ArrayList<Plataforma>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT);
			ResultSet rs = null;
			rs = ps.executeQuery();
			while (rs.next()) {
				Plataforma plataforma = new Plataforma();
				plataforma.setIdPlataforma(rs.getInt("idPlataforma"));
				plataforma.setPlataforma(rs.getString("Plataforma"));
				plataformas.add(plataforma);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o select da plataforma: " + ex);
		} finally {
			getConnection();
		}
		return plataformas;
	}

	
	
	public Plataforma buscarPorId(long id) {
		Plataforma plataforma = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ResultSet rs = null;
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				plataforma = new Plataforma();
				plataforma.setIdPlataforma(rs.getLong("idPlataforma"));
				plataforma.setPlataforma(rs.getString("Plataforma"));
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o select por id: " + ex);
		} finally {
			getConnection();
		}
		return plataforma;
	}

}