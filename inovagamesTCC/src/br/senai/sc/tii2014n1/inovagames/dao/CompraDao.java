package br.senai.sc.tii2014n1.inovagames.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Compra;

public class CompraDao extends DAO {

	private final String INSERT = "INSERT INTO compra (quantidade) VALUES (?)";
	private final String UPDATE = "UPDATE compra SET quantidade = ? WHERE idQuantidade = ?";
	private final String DELETE = "DELETE FROM compra WHERE idCompra = ?";
	private final String SELECT = "SELECT * FROM compra";
	private final String SELECT_ID = "SELECT * FROM compra WHERE idCompra = ?";

	
	public void salvar(Compra compra) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setInt(1, compra.getQuantidade());
			//ps.setLong(2, compra.getCliente().getIdCliente());
			//ps.setLong(3, compra.getProduto().getIdProduto());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o insert: " + ex);
		} finally {
			getConnection();
		}
	}

	
	public void alterar(Compra compra) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(UPDATE);
			ps.setInt(1, compra.getQuantidade());
			//ps.setLong(2, compra.getCliente().getIdCliente());
			//ps.setLong(3, compra.getProduto().getIdProduto());
			ps.setLong(4, compra.getIdCompra());
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

	
	public List<Compra> listarTodos() {
		List<Compra> compras = new ArrayList<Compra>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT);
			ResultSet rs = null;
			rs = ps.executeQuery();
			while (rs.next()) {
				Compra compra = new Compra();
				compra.setIdCompra(rs.getInt("idCompra"));
				compra.setQuantidade(rs.getInt("Quantidade"));
				
				//ClienteDao clienteDao = DAOFactory.getClienteDao();
				//compra.setCliente(clienteDao.buscarPorId(rs
						//.getLong("idCliente")));// chave estrangeira

				//ProdutoDao produtoDao = DAOFactory.getProdutoDao();
				//compra.setProduto(produtoDao.buscarPorId(rs
						//.getLong("idProduto")));// chave estrangeira
				compras.add(compra);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o select da Compra: " + ex);
		} finally {
			getConnection();
		}
		return compras;
	}

	
	
	
	public Compra buscarPorId(long id) {
		Compra compra = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ResultSet rs = null;
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				compra = new Compra();
				compra.setIdCompra(rs.getLong("idCompra"));
				compra.setQuantidade(rs.getInt("Quantidade"));
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o select por id: " + ex);
		} finally {
			getConnection();
		}
		return compra;
	}

}
