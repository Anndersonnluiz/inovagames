package br.senai.sc.tii2014n1.inovagames.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Plataforma;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.PlataformaRN;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.Produto;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.ProdutoRN;

@ManagedBean
@ViewScoped
public class ProdutoMB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private ProdutoRN produtoRN;
	private Produto produtoSelecionado;
	private List<Produto> produtos;
	private Plataforma plataforma;
	private List<Plataforma> listaPlataformas;

	@PostConstruct
	public void init() {
		produtoRN = new ProdutoRN();
		if (produto == null) {
			produto = new Produto();
		}
		gerarListaProduto();
		gerarListaPlataforma();
	}
	
	

	public List<Plataforma> getListaPlataformas() {
		return listaPlataformas;
	}



	public void setListaPlataformas(List<Plataforma> listaPlataformas) {
		this.listaPlataformas = listaPlataformas;
	}



	public ProdutoRN getProdutoRN() {
		return produtoRN;
	}



	public void setProdutoRN(ProdutoRN produtoRN) {
		this.produtoRN = produtoRN;
	}



	public Plataforma getPlataforma() {
		return plataforma;
	}



	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}



	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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

	public String alterar(Produto produto) {
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
	
	public void gerarListaPlataforma() {
        PlataformaRN plataformaRN = new PlataformaRN();
        try {
            listaPlataformas = plataformaRN.listar("Select * from Plataforma ");
            if (listaPlataformas == null) {
            	listaPlataformas = new ArrayList<Plataforma>();
            }
        } catch (Exception ex) {
            Logger.getLogger(PlataformaMB.class.getName()).log(Level.SEVERE, null, ex);
            mostrarMensagem(ex, "Erro ao gerar a lista de plataforma", "Erro");
        }
        
    }
	
	public void mostrarMensagem(Exception ex, String erro, String titulo){
        FacesContext context = FacesContext.getCurrentInstance();
        erro = erro + " - " + ex;
        context.addMessage(null, new FacesMessage(titulo, erro));
    }

}
