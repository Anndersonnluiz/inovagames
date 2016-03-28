package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import java.util.List;

import br.senai.sc.tii2014n1.inovagames.dao.PlataformaDao;

public class PlataformaRN {

	private PlataformaDao Dao;
	
	public PlataformaRN(){
		
		Dao = new PlataformaDao();
		
	}
	 
	 public void salvar(Plataforma plataforma) throws Exception{
		 if (plataforma.getNomeplataforma().equalsIgnoreCase("")) {
			 throw new Exception("O nome da plataforma 'e obrigatorio!!");
		}
		 
		Dao.salvar(plataforma);
		  
	 }
	 
	 public List<Plataforma> listar(String sql){
			return Dao.listarTodos(sql);
		}
		
		public Plataforma buscarPorId(int id) {
			return Dao.buscarPorId(id);
		}
		
		public void excluir(Integer id) throws Exception{
			Dao.excluir(id);
		}

}
