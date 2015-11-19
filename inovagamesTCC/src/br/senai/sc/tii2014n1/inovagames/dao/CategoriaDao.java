package br.senai.sc.tii2014n1.inovagames.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Categoria;

public class CategoriaDao extends DAO {

	private final String INSERT = "INSERT INTO categoria (categoria) VALUES (?)";
	private final String UPDATE = "UPDATE categoria SET categoria = ? WHERE idCategoria = ?";
	private final String DELETE = "DELETE FROM categoria WHERE id = ?";
	private final String SELECT = "SELECT * FROM categoria";
	private final String SELECT_ID = "SELECT * FROM categoria WHERE idCategoria = ?";

	public void salvar(Categoria categoria) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, categoria.getCategoria());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o insert: " + ex);
		} finally {
			getConnection();
		}
	}

	public void alterar(Categoria categoria) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(UPDATE);
			ps.setString(1, categoria.getCategoria());
			ps.setLong(2, categoria.getIdCategoria());
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

	public List<Categoria> listarTodos() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT);
			ResultSet rs = null;
			rs = ps.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setIdCategoria(rs.getLong("idCategoria"));
				categoria.setCategoria(rs.getString("Categoria"));
				categorias.add(categoria);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o select da categoria: " + ex);
		} finally {
			getConnection();
		}
		return categorias;
	}

	

	public Categoria buscarPorId(long id) {
		Categoria categoria = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ResultSet rs = null;
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				categoria = new Categoria();
				categoria.setIdCategoria(rs.getLong("idCategoria"));
				categoria.setCategoria(rs.getString("Categoria"));
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o select por id: " + ex);
		} finally {
			getConnection();
		}
		return categoria;
	}

}
