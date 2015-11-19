package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import java.util.List;

import br.senai.sc.tii2014n1.inovagames.dao.CompraDao;

public class CompraRN {

	private CompraDao Dao;
	
	
	 public CompraRN(){
		
		Dao = new CompraDao();
	}
	 
	 public void salvar(Compra compra) throws Exception{
		Dao.salvar(compra);
		  
	 }
	 
	 public List<Compra> listar(){
			return Dao.listarTodos();
		}
		
		public Compra buscarPorId(int id) {
			return Dao.buscarPorId(id);
		}
		
		public void excluir(Integer id) throws Exception{
			Dao.excluir(id);
		}
}
