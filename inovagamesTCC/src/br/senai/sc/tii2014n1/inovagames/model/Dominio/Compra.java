package br.senai.sc.tii2014n1.inovagames.model.Dominio;

public class Compra {

	private long idCompra;
	private int quantidade;
	private Cliente cliente;
	private Produto produto;

	public Compra() {
		cliente = new Cliente();
		produto = new Produto();
	}

	public Compra(int idCompra, int quantidade) {
		super();
		this.idCompra = idCompra;
		this.quantidade = quantidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
	 this.cliente = cliente;
	}

	public Produto getProduto() {
	 return produto;
	}

	public void setProduto(Produto produto) {
	 this.produto = produto;
	}

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
