package br.senai.sc.tii2014n1.inovagames.managebean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Produtolancamento;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.ProdutoLancamentoRN;

@ManagedBean
@SessionScoped
public class ProdutoLancamentoMB {
	private Produtolancamento produtoLancamento;
	private List<Produtolancamento> produtoLancamentos;
	private ProdutoLancamentoRN produtoLancamentoRN;
	
	@PostConstruct
	public void init(){
		produtoLancamentoRN = new ProdutoLancamentoRN();
			produtoLancamento = new Produtolancamento();
	}

	public Produtolancamento getProdutoLancamento() {
		return produtoLancamento;
	}

	public void setProdutoLAncamento(Produtolancamento produtoLancamento) {
		this.produtoLancamento = produtoLancamento;
	}

	public List<Produtolancamento> getProdutoLancamentos() {
		if (produtoLancamentos == null) {
			produtoLancamentos = produtoLancamentoRN.listar();
		}
		return produtoLancamentos;
	}
	
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			produtoLancamentoRN.salvar(produtoLancamento);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cadastro feito com sucesso!", "");
			context.addMessage(null, message);
			produtoLancamento = new Produtolancamento();
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
		}

		return null;

	
	}
	
}
