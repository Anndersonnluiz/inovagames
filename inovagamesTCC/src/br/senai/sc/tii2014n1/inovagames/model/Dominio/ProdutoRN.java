package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import java.util.List;

import br.senai.sc.tii2014n1.inovagames.dao.ProdutoDao;

public class ProdutoRN {

	private ProdutoDao Dao;
	
	public ProdutoRN(){
		Dao = new ProdutoDao();
	}
	 
	 public void salvar(Produto produto) throws Exception{
		 if (produto.getDescricao().equalsIgnoreCase("")) {
			 throw new Exception("A descricao e obrigatoria");
		}
		 
		Dao.salvar(produto);
		  
	 }
	 
	 public List<Produto> listar(String sql){
			return Dao.listar(sql);
		}
		
		public Produto buscarPorId(int id) {
			return Dao.consultarPorId(id);
		}
		
		public void excluir(Integer id) throws Exception{
			Dao.excluir(id);
		}

}
