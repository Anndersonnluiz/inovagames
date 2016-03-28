package br.senai.sc.tii2014n1.inovagames.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Produto;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.ProdutoRN;

@ManagedBean
@SessionScoped
public class ProdutoMB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private ProdutoRN produtoRN;
	private Produto produtoSelecionado;
	private List<Produto> produtos;

	@PostConstruct
	public void init() {
		produtoRN = new ProdutoRN();
		if (produto == null) {
			produto = new Produto();
		}
		gerarListaProduto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public String salvar() {
		try {
			produtoRN.salvar(produto);
			produto = new Produto();
			produtos = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public String novo() {
		produto = new Produto();
		return "cadastroProduto";
	}

	public String alterar() {
		produto = produtoSelecionado;
		produtoSelecionado = null;
		return "/administradores";
	}

	public String excluir(String idParam){
		int id = Integer.parseInt(idParam);
		try {
			produtoRN.excluir(id);
			produtos = null;
			FacesContext.getCurrentInstance().addMessage(
					null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto removido com sucesso!", ""));
			return "";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	
	public String Salvar(){
		try {
			produtoRN.salvar(produto);
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void gerarListaProduto(){
		ProdutoRN produtoRN = new ProdutoRN();
		produtos = produtoRN.listar("Select * from Produto");
		if (produtos == null) {
			produtos = new ArrayList<Produto>();
		}
	}

}
