package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import java.util.List;

import br.senai.sc.tii2014n1.inovagames.dao.ClienteDao;

public class ClienteRN {

	
	private ClienteDao Dao;
	
	 public ClienteRN(){
		
		Dao = new ClienteDao();
	}
	 
	 public void salvar(Cliente cliente) throws Exception {
		 if (cliente.getNome().equalsIgnoreCase("")) {
			 throw new Exception("O nome é obrigatório!!");
		}
		 
		Dao.salvar(cliente);
		  
	 }
	 
	 public List<Cliente> listar(){
			return Dao.listarTodos();
		}
		
		public Cliente buscarPorId(int id) {
			return Dao.buscarPorId(id);
		}
		
		public void excluir(Integer id) throws Exception{
			Dao.excluir(id);
		}
}
