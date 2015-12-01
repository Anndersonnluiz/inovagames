package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import br.senai.sc.tii2014n1.inovagames.dao.UserDao;





public class UserRN {
	private UserDao Dao;
	
	 public UserRN() {
		
		Dao = new UserDao();
	}
	 
	  
	 public void salvar(User user) throws Exception{
		 if (user.getEmail().equalsIgnoreCase("")) {
			 throw new Exception("o email é obrigatorio");
		}
		 
		Dao.salvar(user);
		  
	 }
	 
		public User buscaPorEmail(String email) {
			return Dao.buscarPorEmail(email);
		}
		
		public User buscaPorTipoAcesso(String tipoAcesso) {
			return Dao.buscarPorTipoAcesso(tipoAcesso);
		}
}
