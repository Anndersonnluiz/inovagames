package br.senai.sc.tii2014n1.inovagames.model.Dominio;

public class Produtolancamento {

	private Integer id;
	private String nome;
	private Double valor;
	
	public Produtolancamento() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	

	
	public Produtolancamento(Integer id, String nome, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
}
