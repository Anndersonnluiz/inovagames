package br.senai.sc.tii2014n1.inovagames.model.Dominio;

public class Categoria {
	
	private long idCategoria;
	private String categoria;
	

	public Categoria() {
		

	}

	public Categoria(int idCategoria, String categoria) {

		this.idCategoria = idCategoria;
		this.categoria = categoria;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
