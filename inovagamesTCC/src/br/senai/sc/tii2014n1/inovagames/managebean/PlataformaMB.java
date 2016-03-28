package br.senai.sc.tii2014n1.inovagames.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Plataforma;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.PlataformaRN;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.Produto;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.ProdutoRN;

@ManagedBean
@SessionScoped
public class PlataformaMB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plataforma plataforma;
	private PlataformaRN plataformaRN;
	private Plataforma plataformaSelecionado;
	private List<Plataforma> plataformas;
	private String nomePlataforma;
	private List<Produto> listaProduto;
	

	@PostConstruct
	public void init() {
		plataformaRN = new PlataformaRN();
		plataforma = new Plataforma();
		gerarListaPlataforma();
	}
	
	

	public List<Produto> getListaProduto() {
		return listaProduto;
	}



	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}



	public String getNomePlataforma() {
		return nomePlataforma;
	}



	public void setNomePlataforma(String nomePlataforma) {
		this.nomePlataforma = nomePlataforma;
	}



	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public Plataforma getPlataformaSelecionado() {
		return plataformaSelecionado;
	}

	public void setPlataformaSelecionado(Plataforma plataformaSelecionado) {
		this.plataformaSelecionado = plataformaSelecionado;
	}

	public List<Plataforma> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			plataformaRN.salvar(plataforma);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Plataforma cadastrado com sucesso!", "");
			context.addMessage(null, message);
			plataforma = new Plataforma();
			plataformas = null;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
		}

		return null;

	}

	public String novo() {
		plataforma = new Plataforma();
		return "cadastroPlataforma";
	}

	public String alterar() {
		plataforma = plataformaSelecionado;
		plataformaSelecionado = null;
		return "cadastroPlataforma";
	}

	public String excluir(String idParam){
		int id = Integer.parseInt(idParam);
		try {
			plataformaRN.excluir(id);
			plataformas.remove(plataformaSelecionado);
			plataformaSelecionado = null;
			FacesContext.getCurrentInstance().addMessage(
					null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Plataforma removido com sucesso!", ""));
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}

	public String voltar() {
		return "listarPlataformas";
	}
	
	public void pesquisar(){
		String sql = "Select * From Produto JOIN Plataforma on Produto.plataforma.idplataforma=Plataforma.idplataforma"
				+ " Where Produto.plataforma.idplataforma=" + plataforma;
		ProdutoRN produtoRN = new ProdutoRN();
		listaProduto = produtoRN.listar(sql);
		if (listaProduto == null) {
			listaProduto = new  ArrayList<Produto>();
		}
		
	}
	
	public void gerarListaPlataforma() {
        PlataformaRN plataformaRN = new PlataformaRN();
        try {
            plataformas = plataformaRN.listar("Select * from Plataforma ");
            if (plataformas == null) {
                plataformas = new ArrayList<Plataforma>();
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
