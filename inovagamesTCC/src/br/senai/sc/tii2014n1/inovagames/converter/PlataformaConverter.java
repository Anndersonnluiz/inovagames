package br.senai.sc.tii2014n1.inovagames.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.tii2014n1.inovagames.model.Dominio.Plataforma;

@FacesConverter(value="PlataformaConverter")
public class PlataformaConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		List<Plataforma> listaPlataforma = (List<Plataforma>) arg1.getAttributes().get("listaPlataforma");
	    if (listaPlataforma != null) {
	        for (Plataforma plataforma : listaPlataforma) {
	            if (plataforma.getNomeplataforma().equalsIgnoreCase(arg2)) {
	                return plataforma;
	            }
	        }
	    } else {
	    	Plataforma plataforma = new Plataforma();
	        return plataforma;
	    }
	    Plataforma banco = new Plataforma();
	    return banco;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Plataforma banco = (Plataforma) arg2;
	        return banco.getNomeplataforma();
	    }
	}

}
