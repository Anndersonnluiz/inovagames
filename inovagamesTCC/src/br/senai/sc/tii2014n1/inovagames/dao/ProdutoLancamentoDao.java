package br.senai.sc.tii2014n1.inovagames.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.tii2014n1.inovagames.connection.ConectionFactory;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.Produtolancamento;

public class ProdutoLancamentoDao{
	

	
	public Produtolancamento salvar(Produtolancamento produtolancamento){
		EntityManager em = ConectionFactory.getConnection();
		em.getTransaction().begin();
		produtolancamento = em.merge(produtolancamento);
		em.getTransaction().commit();
		em.close();
		return produtolancamento;
	}
	
	public List<Produtolancamento> listar(String sql){
		EntityManager em = ConectionFactory.getConnection();
		if (sql == null) {
			sql = "Select * from Produtolancamento";
		}
		Query query = em.createQuery(sql);
		List<Produtolancamento> listaProdutoLancamento = query.getResultList();
		em.close();
		return listaProdutoLancamento;
	}
	
	public void excluir(int id){
		EntityManager em = ConectionFactory.getConnection();
		em.getTransaction().begin();
		Produtolancamento produtolancamento = em.find(Produtolancamento.class, id);
		em.remove(produtolancamento);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
