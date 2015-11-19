package br.senai.sc.tii2014n1.inovagames.model.Dominio;

public class Produto {

	private long idProduto;
	private int codigoDeBarras;
	private String nome;
	private Double valor;
	private String marca;
	private int quantidade;
	private String descricao;
	private Categoria categoria;
	private Plataforma plataforma;

	public Produto() {
		 categoria = new Categoria();
		 plataforma = new Plataforma();

	}

	public Produto(int idProduto, int codigoDeBarras, String nome,
			Double valor, String marca, int quantidade, String descricao) {
		super();
		this.idProduto = idProduto;
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.valor = valor;
		this.marca = marca;
		this.quantidade = quantidade;
		this.descricao = descricao;
	}

	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public int getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(int codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
