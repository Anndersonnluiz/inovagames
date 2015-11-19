package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import br.senai.sc.tii2014n1.inovagames.dao.UserDao;





public class UserRN {
	private UserDao Dao;
	
	 public UserRN() {
		
		Dao = new UserDao();
	}
	 
	  
		public User buscaPorEmail(String email) {
			return Dao.buscarPorEmail(email);
		}
}
