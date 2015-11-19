package br.senai.sc.tii2014n1.inovagames.managebean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Cliente;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.ClienteRN;

@ManagedBean()
@SessionScoped
public class ClienteMB {
	private Cliente cliente;
	private ClienteRN clienteRN;
	private Cliente clienteSelecionado;
	private List<Cliente> clientes;
	
	@PostConstruct
	public void init() {
		clienteRN = new ClienteRN();
		cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = clienteRN.listar();
		}
		return clientes;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			clienteRN.salvar(cliente);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cliente cadastrado com sucesso!", "");
			context.addMessage(null, message);
			cliente = new Cliente();
			clientes = null;
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
		}

		return null;

	}

	public String novo() {
		cliente = new Cliente();
		return "cadastroCliente";
	}

	public String alterar() {
		cliente = clienteSelecionado;
		clienteSelecionado = null;
		return "cadastroCliente";
	}

	public String excluir(String idParam) {
		int id = Integer.parseInt(idParam);
		try {
			clienteRN.excluir(id);
			clientes.remove(clienteSelecionado);
			clienteSelecionado = null;
			FacesContext.getCurrentInstance().addMessage(
					null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente removido com sucesso!", ""));
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
		}
		

	public String voltar() {
		return "listarClientes";
	}

}
