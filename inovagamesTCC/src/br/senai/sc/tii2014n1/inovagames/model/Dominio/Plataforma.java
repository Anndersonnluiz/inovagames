package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Plataforma implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlataforma")
    private Integer idPlataforma;
	@Column(name = "nomeplataforma")
    private String nomeplataforma;

	public Plataforma() {

	}

	public Plataforma(int idPlataforma, String nomeplataforma) {
		super();
		this.idPlataforma = idPlataforma;
		this.nomeplataforma = nomeplataforma;
	}

	

	public Integer getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public String getNomeplataforma() {
		return nomeplataforma;
	}

	public void setNomeplataforma(String nomeplataforma) {
		this.nomeplataforma = nomeplataforma;
	}

	 @Override
	    public boolean equals(Object object) {
	        // 
	        if (!(object instanceof Plataforma)) {
	            return false;
	        }
	        Plataforma other = (Plataforma) object;
	        if ((this.idPlataforma == null && other.idPlataforma != null) || (this.idPlataforma != null && !this.idPlataforma.equals(other.idPlataforma))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "model.Plataforma[ idPlataforma=" + idPlataforma + " ]";
	    }

}
