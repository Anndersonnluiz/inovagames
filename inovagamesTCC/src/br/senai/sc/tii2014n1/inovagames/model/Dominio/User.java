package br.senai.sc.tii2014n1.inovagames.model.Dominio;

public class User {

	private String email;
	private String senha;
	private String tipoAcesso;
	
	
	public User(){
		
	}
	
	
	
	public String getTipoAcesso() {
		return tipoAcesso;
	}



	public void setTipoAcesso(String tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public User(String email, String senha, String tipoAcesso) {
		super();
		this.email = email;
		this.senha = senha;
		this.tipoAcesso = tipoAcesso;
	}
	
	
}
