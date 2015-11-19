package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import java.util.List;

import br.senai.sc.tii2014n1.inovagames.dao.CategoriaDao;


public class CategoriaRN {

	
	private CategoriaDao Dao;
	
	  public CategoriaRN(){
		
		Dao = new CategoriaDao();
	}
	 
	 public void salvar(Categoria categoria) throws Exception{
		 if (categoria.getCategoria().equalsIgnoreCase("")) {
			 throw new Exception("Escolha da categoria é obrigatoria");
		}
		Dao.salvar(categoria);
		  
	 }
	 
	 public List<Categoria> listar(){
			return Dao.listarTodos();
		}
		
		public Categoria buscarPorId(int id) {
			return Dao.buscarPorId(id);
		}
		
		public void excluir(Integer id) throws Exception{
			Dao.excluir(id);
		}
}
