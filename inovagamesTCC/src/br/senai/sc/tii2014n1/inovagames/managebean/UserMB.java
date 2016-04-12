package br.senai.sc.tii2014n1.inovagames.managebean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Cliente;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.User;
import br.senai.sc.tii2014n1.inovagames.model.Dominio.UserRN;
import br.senai.sc.tii2014n1.inovagames.util.Criptografia;


@ManagedBean
@ViewScoped
public class UserMB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserRN userRN;
	private List<User> users;
	private User userSelecionado;
	private String sql;
	
	@PostConstruct
	public void init(){
		userRN = new UserRN();
		if (user == null) {
			user = new User();
			
		}
	}
	
	
	
	public String getSql() {
		return sql;
	}



	public void setSql(String sql) {
		this.sql = sql;
	}



	public User getUserSelecionado() {
		return userSelecionado;
	}



	public void setUserSelecionado(User userSelecionado) {
		this.userSelecionado = userSelecionado;
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
			users = userRN.listar(sql);
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
			String senha  = user.getSenha();
			user.setSenha(Criptografia.encript(senha));
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
	
	public String alterar(User clienteSelecionado) {
		user = clienteSelecionado;
		return "cadastroCliente";
	}

	public String excluir(String idParam) {
		int id = Integer.parseInt(idParam);
		try {
			userRN.excluir(id);
			users.remove(userSelecionado);
			userSelecionado = null;
			FacesContext.getCurrentInstance().addMessage(
					null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente removido com sucesso!", ""));
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
		}
	
}
