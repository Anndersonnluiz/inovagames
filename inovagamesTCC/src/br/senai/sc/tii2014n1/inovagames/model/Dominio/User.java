package br.senai.sc.tii2014n1.inovagames.model.Dominio;

public class User {
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private String senha;
	private String tipoAcesso;
	
	
	public User(){
		
	}
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public User(Integer id, String nome, String email, String cpf, String senha, String tipoAcesso) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.tipoAcesso = tipoAcesso;
	}
	
	
}
