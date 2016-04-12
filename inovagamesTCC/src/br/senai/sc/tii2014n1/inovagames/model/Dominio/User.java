package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
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




    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.senai.sc.tii2014n1.inovagames.model.Dominio.User[ id=" + id + " ]";
    }
	
}
