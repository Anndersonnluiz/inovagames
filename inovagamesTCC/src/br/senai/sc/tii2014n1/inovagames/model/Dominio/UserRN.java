package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import java.util.List;

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
	 
	 public User consultarPorEmail(String email){
		 return Dao.consultarPorEmail(email);
	 }
	 
	 public User consultarPorId(int id){
		 return Dao.consultarPorId(id);
	 }
	 
	 public User consultarPorTipoAcesso(String tipoAcesso){
		 return Dao.consultarPorTipoAcesso(tipoAcesso);
	 }
		
		
	 public List<User> listar(String sql){
		 return Dao.listar(sql);
	 }
		
	 public void excluir(Integer id) throws Exception{
		 Dao.excluir(id);
	 }
}
