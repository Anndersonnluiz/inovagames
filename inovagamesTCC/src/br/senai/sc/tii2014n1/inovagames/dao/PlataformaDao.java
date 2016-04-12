package br.senai.sc.tii2014n1.inovagames.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.tii2014n1.inovagames.connection.ConectionFactory;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.Plataforma;

public class PlataformaDao  {


	
	public Plataforma salvar(Plataforma plataforma){
		EntityManager em = ConectionFactory.getConnection();
		em.getTransaction().begin();
		plataforma = em.merge(plataforma);
		em.getTransaction().commit();
		em.close();
		return plataforma;
	}

	
	public void excluir(int id){
		EntityManager em = ConectionFactory.getConnection();
		em.getTransaction().begin();
		Plataforma plataforma = em.find(Plataforma.class, id);
		em.remove(plataforma);
		em.getTransaction().commit();
		em.close();
	}

	
	public List<Plataforma> listar(String sql){
		EntityManager em = ConectionFactory.getConnection();
		if (sql == null) {
			sql = "Select * from Plataforma";
		}
		Query query = em.createQuery(sql);
		List<Plataforma> listarPlataforma = query.getResultList();
		em.close();
		return listarPlataforma;		
	}

	
	
	public Plataforma consultarPorId(int id){
		EntityManager em = ConectionFactory.getConnection();
		Plataforma plataforma = em.find(Plataforma.class, id);
		em.close();
		return plataforma;
	}

}