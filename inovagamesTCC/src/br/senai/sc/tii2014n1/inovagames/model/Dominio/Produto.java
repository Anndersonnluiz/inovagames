package br.senai.sc.tii2014n1.inovagames.model.Dominio;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Produto implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
	@Column(name = "nome")
	private String nome;
	@Column(name = "valor")
	private Double valor;
	@Column(name = "descricao")
	private String descricao;
	@JoinColumn(name = "plataforma_idplataforma", referencedColumnName = "idplataforma")
	@ManyToOne(optional = false)
	private Plataforma plataforma;

	public Produto() {

	}

	public Produto(int idProduto, int codigoDeBarras, String nome,
			Double valor, String marca, int quantidade, String descricao, Plataforma plataforma) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
		this.plataforma = plataforma;
	}

	

	

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
    public boolean equals(Object object) {
        // 
        if (!(object instanceof Plataforma)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ idProduto=" + idProduto + " ]";
    }

}
