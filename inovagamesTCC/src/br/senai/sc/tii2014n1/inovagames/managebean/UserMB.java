package br.senai.sc.tii2014n1.inovagames.managebean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.User;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.UserRN;


@ManagedBean
@SessionScoped
public class UserMB {
	private User user;
	private UserRN userRN;
	private List<User> users;
	
	@PostConstruct
	public void init(){
		userRN = new UserRN();
		if (user == null) {
			user = new User();
			
		}
	}
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public UserRN getUserRN() {
		return userRN;
	}



	public void setUserRN(UserRN userRN) {
		this.userRN = userRN;
	}



	public List<User> getUsers() {
		if (users == null) {
			users = userRN.listar();
		} 
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			user.setTipoAcesso("usuario");
			userRN.salvar(user);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cadastro feito com sucesso!", "");
			context.addMessage(null, message);
			user = new User();
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);
		}

		return null;

	
	}
	
}
