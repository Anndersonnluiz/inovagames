package br.senai.sc.tii2014n1.inovagames.managebean;

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
public class ProdutoMB {
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
		if (produtos == null) {
			produtos = produtoRN.listar();
		}
		return produtos;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			produtoRN.salvar(produto);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Produto cadastrado com sucesso!", "");
			context.addMessage(null, message);
			produto = new Produto();
			produtos = null;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
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
		return "administradores";
	}

	public String excluir(String idParam){
		int id = Integer.parseInt(idParam);
		try {
			produtoRN.excluir(id);
			produtos.remove(produtoSelecionado);
			produtoSelecionado = null;
			FacesContext.getCurrentInstance().addMessage(
					null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto removido com sucesso!", ""));
			return null;
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

}
