package br.senai.sc.tii2014n1.inovagames.model.Dominio;

public class Plataforma {

	private long idPlataforma;
	private String plataforma;

	public Plataforma() {

	}

	public Plataforma(int idPlataforma, String plataforma) {
		super();
		this.idPlataforma = idPlataforma;
		this.plataforma = plataforma;
	}

	public long getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(long idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

}
