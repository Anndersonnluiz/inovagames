package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import br.senai.sc.tii2014n1.inovagames.dao.ProdutoLancamentoDao;

public class ProdutoLancamentoRN {

	private ProdutoLancamentoDao dao;
	
	public ProdutoLancamentoRN() {
		dao = new ProdutoLancamentoDao();
	}
	
	public void salvar(Produtolancamento produtoLancamento) throws Exception{
		 if (produtoLancamento.getNome().equalsIgnoreCase("")) {
			 throw new Exception("O nome é obrigatorio");
		}
		 
		dao.salvar(produtoLancamento);
		  
	 }
}
