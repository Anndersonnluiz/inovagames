package br.senai.sc.tii2014n1.inovagames.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.tii2014n1.inovagames.connection.ConectionFactory;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.Produto;

public class ProdutoDao  {


	
	public Produto salvar(Produto produto){
		EntityManager em = ConectionFactory.getConnection();
		em.getTransaction().begin();
		produto = em.merge(produto);
		em.getTransaction().commit();
		em.close();
		return produto;
	}

	public void excluir(int id){
		EntityManager em = ConectionFactory.getConnection();
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		em.remove(produto);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<Produto> listar(String sql){
		sql = "Select * from produto";
		EntityManager em = ConectionFactory.getConnection();
		Query query = em.createQuery(sql);
		List<Produto> listarProdutos = query.getResultList();
		em.close();
		return listarProdutos;
	}


	
	public Produto consultarPorId(Integer id){
		EntityManager em = ConectionFactory.getConnection();
		Produto produto =  em.find(Produto.class, id);
		em.close();
		return produto;
	}

}
