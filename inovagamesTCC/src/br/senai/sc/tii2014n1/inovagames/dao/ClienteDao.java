package br.senai.sc.tii2014n1.inovagames.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Cliente;

public class ClienteDao extends DAO {

	private final String INSERT = "INSERT INTO cliente (nome,telefone,email,senha,sexo,cpf,endereco) VALUES (?,?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE cliente SET nome = ?, telefone = ?, email = ?, senha = ?, sexo = ?,cpf = ?,endereco = ? WHERE idcliente = ?";
	private final String DELETE = "DELETE FROM cliente WHERE idCliente = ?";
	private final String SELECT = "SELECT * FROM cliente";
	private final String SELECT_ID = "SELECT * FROM cliente WHERE idCliente = ?";

	public void salvar(Cliente cliente) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getSenha());
			ps.setString(5, cliente.getSexo());
			ps.setString(6, cliente.getCpf());
			ps.setString(7, cliente.getEndereco());

			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o insert: " + ex);
		} finally {
			getConnection();
		}
	}

	public void alterar(Cliente cliente) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(UPDATE);
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getSenha());
			ps.setString(5, cliente.getSexo());
			ps.setString(6, cliente.getCpf());
			ps.setString(7, cliente.getEndereco());
			ps.setLong(8, cliente.getIdCliente());

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
			System.out.println("Erro a executar o delete: " + ex);
		} finally {
			getConnection();
		}
	}

	public List<Cliente> listarTodos() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT);
			ResultSet rs = null;
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getInt("telefone"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));

				cliente.setIdCliente(rs.getLong("idCliente"));
				clientes.add(cliente);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o select do cliente: " + ex);
		} finally {
			getConnection();
		}
		return clientes;
	}

	

	
	public Cliente buscarPorId(long id) {
		Cliente cliente = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ResultSet rs = null;
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getInt("telefone"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setIdCliente(rs.getLong("idCliente"));

			}
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o select por ID: " + ex);
		} finally {
			getConnection();
		}
		return cliente;
	}

}
