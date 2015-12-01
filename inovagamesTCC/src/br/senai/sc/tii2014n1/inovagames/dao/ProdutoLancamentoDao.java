package br.senai.sc.tii2014n1.inovagames.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Produtolancamento;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.User;

public class ProdutoLancamentoDao extends DAO{

	private final String INSERT = "INSERT INTO produtolancamento (nome, valor) VALUES (?,?)";
	private final String UPDATE = "UPDATE produtolancamento SET nome = ?, valor = ?  WHERE id = ?";
	
	public void salvar(Produtolancamento produtoLancamento){
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, produtoLancamento.getNome());
			ps.setDouble(2, produtoLancamento.getValor());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void Editar(Produtolancamento produtoLancamento){
		try {
			PreparedStatement ps = getConnection().prepareStatement(UPDATE);
			ps.setString(1, produtoLancamento.getNome());
			ps.setDouble(2, produtoLancamento.getValor());
			ps.setInt(3, produtoLancamento.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
