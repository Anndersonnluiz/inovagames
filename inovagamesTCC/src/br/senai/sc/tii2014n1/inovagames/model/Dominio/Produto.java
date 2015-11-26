package br.senai.sc.tii2014n1.inovagames.model.Dominio;

public class Produto {

	private int idProduto;
	private String nome;
	private Double valor;
	private String descricao;

	public Produto() {

	}

	public Produto(int idProduto, int codigoDeBarras, String nome,
			Double valor, String marca, int quantidade, String descricao) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
	}

	

	

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
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
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
