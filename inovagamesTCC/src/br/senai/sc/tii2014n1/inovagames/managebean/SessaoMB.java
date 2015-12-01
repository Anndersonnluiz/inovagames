package br.senai.sc.tii2014n1.inovagames.managebean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.User;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.UserRN;


@ManagedBean
@SessionScoped
public class SessaoMB {
	private User usuarioLogado;
	private User usuarioForm;
	
	@PostConstruct
	public void iniciar(){
		setUsuarioForm(new User());
	}

	public User getUsuarioForm() {
		return usuarioForm;
	}

	public void setUsuarioForm(User usuarioForm) {
		this.usuarioForm = usuarioForm;
	}
	
	public String entrar(){
		UserRN userRN = new UserRN();
		User usuarioBanco = userRN.buscaPorEmail(usuarioForm.getEmail());
		if (usuarioBanco != null
				&& getUsuarioForm().getEmail().equalsIgnoreCase(usuarioBanco.getEmail())
				&& getUsuarioForm().getSenha().equals(usuarioBanco.getSenha())) {
			
			usuarioLogado = usuarioBanco;
			return "/index";
		}
		return "";
	}
	
	public String sair(){
		usuarioLogado = null;
		return"/index?faces-redirect=true";
	}
	
	public Boolean estaLogado(){
		return usuarioLogado != null;
	}
	
	public Boolean tipoAcesso(){
		UserRN userRN = new UserRN();
		User usuarioBanco = userRN.buscaPorTipoAcesso(usuarioForm.getTipoAcesso());
		if (usuarioBanco != null
				&& getUsuarioForm().getTipoAcesso().equalsIgnoreCase(usuarioBanco.getTipoAcesso())) {
			
			usuarioLogado = usuarioBanco;
			return usuarioLogado != null;
		}
		return null;
	}
	
}
