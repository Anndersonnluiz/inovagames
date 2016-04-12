package br.senai.sc.tii2014n1.inovagames.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.tii2014n1.inovagames.connection.ConectionFactory;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.User;


public class UserDao{
	
	
	
	
	public User salvar(User user){
		EntityManager em = ConectionFactory.getConnection();
		em.getTransaction().begin();
		user = em.merge(user);
		em.getTransaction().commit();
		em.close();
		return user;
	}
	
	
	public List<User> listar(String sql){
		EntityManager em = ConectionFactory.getConnection();
		if (sql == null) {
			sql = "Select * from User";
		}
		Query query = em.createQuery(sql);
		List<User> listaUsuarios = query.getResultList();
		em.close();
		return listaUsuarios;
	}
	
	
	public void excluir(Integer id){
		EntityManager em = ConectionFactory.getConnection();
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.remove(user);
		em.getTransaction().commit();
		em.close();
	}
	
	public User consultarPorId(int id){
		EntityManager em = ConectionFactory.getConnection();
		User user = em.find(User.class, id);
		em.close();
		return user;
	}
	
	public User consultarPorEmail(String email){
		EntityManager em = ConectionFactory.getConnection();
		User user = em.find(User.class, email);
		em.close();
		return user;
				
	}
	
	public User consultarPorTipoAcesso(String tipoAcesso){
		EntityManager em = ConectionFactory.getConnection();
		User user = em.find(User.class, tipoAcesso);				
		em.close();
		return user;
	}

}
