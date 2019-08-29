package br.senai.sc.tii2014n1.inovagames.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Formatacao {
	
	
	public Integer ConvertStringtoInteger(String valor) {
		return Integer.parseInt(valor);
	}
	
	
	public Float ConvertStringToFloat(String valor) {
		return Float.parseFloat(valor);
	}
	
	
	public Long ConvertStringToLong(String valor){
		return Long.parseLong(valor);
	}
	
	
	public Float ReturnMedia(List<Float> listaNotas) {
		if (listaNotas == null) {
			return 0f;
		}
		int quantidade = listaNotas.size();
		float totalNotas = 0f;
		for (int i = 0; i < listaNotas.size(); i++) {
			totalNotas = totalNotas + listaNotas.get(i);
		}
		return totalNotas/quantidade;
	}
	
	public static String formatFloatStringOutras(Float valor) {
		NumberFormat format = new DecimalFormat("#,###.####");
		format.setMinimumFractionDigits(2);
		String valorFormatado = format.format(valor);
		return valorFormatado;
	}
	
	
	public String schoolCalculation(List<Float> listaNotas, Float nMedia) {
		if (listaNotas == null) {
			return "Sem notas informadas";
		}
		int quantidade = listaNotas.size();
		float totalNotas = 0f;
		for (int i = 0; i < listaNotas.size(); i++) {
			totalNotas = totalNotas + listaNotas.get(i);
		}
		float media =  totalNotas/quantidade;
		if (media >= nMedia) {
			return "Parabéns, Aprovado com a média: " + formatFloatStringOutras(media);
		}else {
			return "Reprovado com a média: " + formatFloatStringOutras(media);
		}
	}
	
	
	
	public boolean validarCalculadora4(float valor) {
		if (valor < 0 || valor > 4) {
			return false;
		}
		return true;
	}
	
	
	public String retornarNomeMes(int nMes) {
		if(nMes == 1) {
			return "Janeiro";
		}else if(nMes == 2){
			return "Fevereiro";
		}else if(nMes == 3){
			return "Março";
		}else if(nMes == 4){
			return "Abril";
		}else if(nMes == 5){
			return "Maio";
		}else if(nMes == 6){
			return "Junho";
		}else if(nMes == 7){
			return "Julho";
		}else if(nMes == 8){
			return "Agosto";
		}else if(nMes == 9){
			return "Setembro";
		}else if(nMes == 10){
			return "Outubro";
		}else if(nMes == 11){
			return "Novembro";
		}else if(nMes == 12){
			return "Dezembro";
		}else {
			return "Informe um número de 1 a 12";
		}
	
	
	
	}
	
	
	public static String ConvercaoDataDDMMAAAA(Date data) {
		DateFormat df = new SimpleDateFormat("ddMMyyyy");
		String dataFormatada = df.format(data);
		return dataFormatada;
	}
	
	
	public static String ConvercaoDataPadrao(Date data) {
		if (data == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = df.format(data);
		return dataFormatada;
	}
	
	
	public static String nomeMes(int mes) {
		if (mes == 1) {
			return "JANEIRO";
		} else if (mes == 2) {
			return "FEVEREIRO";
		} else if (mes == 3) {
			return "MARÇO";
		} else if (mes == 4) {
			return "ABRIL";
		} else if (mes == 5) {
			return "MAIO";
		} else if (mes == 6) {
			return "JUNHO";
		} else if (mes == 7) {
			return "JULHO";
		} else if (mes == 8) {
			return "AGOSTO";
		} else if (mes == 9) {
			return "SETEMBRO";
		} else if (mes == 10) {
			return "OUTUBRO";
		} else if (mes == 11) {
			return "NOVEMBRO";
		} else if (mes == 12) {
			return "DEZEMBRO";
		} else
			return "nao encontrado";
	}
	
	public static float jurosInvestimento(int opcao) {
		// Opção 1: Poupança, Opção 2: Selic, Opção 3: Tesouro, Opção 4: Bolsa;
		if (opcao == 1) {
			return 0.4f;
		}else if(opcao == 2) {
			return 1.2f;
		}else if(opcao == 3) {
			return 3.4f;
		}else if(opcao == 4) {
			return 4.7f;
		}else {
			return 0f;
		}
	}
	
	
	
	
	

} 
