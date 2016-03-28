package br.senai.sc.tii2014n1.inovagames.managebean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class PrincipalMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init(){
	}
	
	public String entrar() {
		return "login";
	 }

}
