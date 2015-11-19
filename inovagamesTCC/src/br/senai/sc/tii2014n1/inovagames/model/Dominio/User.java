package br.senai.sc.tii2014n1.inovagames.model.Dominio;

public class User {

	private String email;
	private String senha;
	
	public User(){
		
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

	public User(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	
	
}
