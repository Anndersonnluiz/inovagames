package br.senai.sc.tii2014n1.inovagames.managebean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Plataforma;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.PlataformaRN;

@ManagedBean(name = "plataformaBean")
@SessionScoped
public class PlataformaMB {
	private Plataforma plataforma;
	private PlataformaRN plataformaRN;
	private Plataforma plataformaSelecionado;
	private List<Plataforma> plataformas;

	@PostConstruct
	public void init() {
		plataformaRN = new PlataformaRN();
		plataforma = new Plataforma();
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
		if (plataformas == null) {
			plataformas = plataformaRN.listar();
		}
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

}
