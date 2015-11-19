package br.senai.sc.tii2014n1.inovagames.managebean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Compra;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.CompraRN;

@ManagedBean()
@SessionScoped
public class CompraMB {
	private Compra compra;
	private CompraRN compraRN;
	private Compra compraSelecionado;
	private List<Compra> compras;

	@PostConstruct
	public void init() {
		compraRN = new CompraRN();
		compra = new Compra();
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Compra getCompraSelecionado() {
		return compraSelecionado;
	}

	public void setCompraSelecionado(Compra compraSelecionado) {
		this.compraSelecionado = compraSelecionado;
	}

	public List<Compra> getCompras() {
		if (compras == null) {
			compras = compraRN.listar();
		}
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			compraRN.salvar(compra);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Compra cadastrado com sucesso!", "");
			context.addMessage(null, message);
			compra = new Compra();
			compras = null;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
		}

		return null;

	}

	public String novo() {
		compra = new Compra();
		return "cadastroCompra";
	}

	public String alterar() {
		compra = compraSelecionado;
		compraSelecionado = null;
		return "cadastroCompra";
	}

	public String excluir(String idParam){
		int id = Integer.parseInt(idParam);
		try {
			compraRN.excluir(id);
			compras.remove(compraSelecionado);
			compraSelecionado = null;
			FacesContext.getCurrentInstance().addMessage(
					null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Compra removido com sucesso!", ""));
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}

	public String voltar() {
		return "listarCompras";
	}
}
