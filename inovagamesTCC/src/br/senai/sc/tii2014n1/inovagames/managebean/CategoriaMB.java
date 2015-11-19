package br.senai.sc.tii2014n1.inovagames.managebean;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Categoria;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.CategoriaRN;

@ManagedBean()
@SessionScoped
public class CategoriaMB {
	
	private Categoria categoria;
	private CategoriaRN categoriaRN;
	private Categoria categoriaSelecionado;
	private List<Categoria> categorias;
	
	@PostConstruct
	public void init() {
		categoriaRN = new CategoriaRN();
		categoria = new Categoria();
		
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoriaSelecionado() {
		return categoriaSelecionado;
	}

	public void setCategoriaSelecionado(Categoria categoriaSelecionado) {
		this.categoriaSelecionado = categoriaSelecionado;
	}

	public List<Categoria> getCategorias() {
		if (categorias == null) {
			categorias = categoriaRN.listar();
		}
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			categoriaRN.salvar(categoria);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Categoria cadastrado com sucesso!", "");
			context.addMessage(null, message);
			categoria = new Categoria();
			categorias = null;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
		}

		return null;

	}

	public String novo() {
		categoria = new Categoria();
		return "cadastroCategoria";
	}

	public String alterar() {
		categoria = categoriaSelecionado;
		categoriaSelecionado = null;
		return "cadastroCategoria";
	}

	public String excluir(String idParam) {
		int id = Integer.parseInt(idParam);
		try {
			categoriaRN.excluir(id);
			categorias.remove(categoriaSelecionado);
			categoriaSelecionado = null;
			FacesContext.getCurrentInstance().addMessage(
					null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Categoria removido com sucesso!", ""));
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
		
	}

	public String voltar() {
		return "listarCategorias";
	}
}
