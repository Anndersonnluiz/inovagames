package br.senai.sc.tii2014n1.inovagames.managebean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.senai.sc.tii2014n1.inovagames.dao.UserDao;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.User;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.UserRN;


@ManagedBean
@ViewScoped
public class SessaoMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public String validarUsuario(){
		UserRN userRN = new UserRN();
		User usuarioBanco = userRN.buscaPorEmail(usuarioForm.getEmail());
        if ((usuarioBanco.getEmail()==null) && (usuarioBanco.getSenha()==null)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Acesso Nrgado."));
        }else{
            String senha = "";
            usuarioForm.setSenha(senha);
            usuarioBanco.setSenha("");
			usuarioLogado = usuarioBanco;
			return "index";
        }
        usuarioLogado = usuarioBanco;
        usuarioBanco = new User();
        return "index";
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
