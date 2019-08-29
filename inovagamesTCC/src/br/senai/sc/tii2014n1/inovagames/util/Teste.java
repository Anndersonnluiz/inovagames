package br.senai.sc.tii2014n1.inovagames.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.swing.JOptionPane;

public class Teste {
	
	static Formatacao formatacao = new Formatacao();

	public static void main(String[] args) {
		int nMetodo = chamadaMetodo();
		switch (nMetodo){
	        case 1:
	            calculoMedia();
	            break;
	        case 2:
	            calculoEscolar();
	            break;
	        case 3:
	            descontoCarro();
	            break;
	        case 4:
	            calculoSomar();
	            break;
	        case 5:
	            calculoSomatoria();
	            break;
	        case 6:
	            calculadoraBasica();
	            break;
	        case 7:
	            calculadora4();
	            break;
	        case 8:
	            calculoMediaSalario();
	            break;
	        case 9:
	            retornarMes();
	            break;
	        case 10:
	            investimentoJuros();
	            break;
	        case 11:
	            planoSaude();
	            break;
	        case 12:
	            descontoInss();
	            break;
	        default:
	        	break;
	        case 13:
	        	descobrirIdade();
	        	break;
	        case 14:
	        	emprestimos();
	        	break;
	        case 15:
	        	maiorNumero();
	        	break;
	        case 16:
	        	piramide();
	        	break;
	        case 17:
	        	supermercado();
	        	break;
	        case 18:
	        	margemEmpresa();
	        	break;
	        case 19:
	        	solucaoFinanceira();
	        	break;
	        case 20:
	        	ordemDecrescente();
	        	break;
	        case 21:
	        	gravarArquivo();
	        	break;
	    }
	}
	
	
	public static int chamadaMetodo() {
		String mensagem = "Informe o número do programa que deseja: \n"
				+ "1) Calculo de média; \n"
				+ "2) Calculo Escolar; \n"
				+ "3) Desconto de Carro \n"
				+ "4) Calculo Somar \n"
				+ "5) Calculo Somatória \n"
				+ "6) Calculadora Basica \n"
				+ "7) Calculadora 4 \n"
				+ "8) Média Salarial \n"
				+ "9) Nome do mês \n"
				+ "10) Investimento com juros \n"
				+ "11) Plano de saúde \n"
				+ "12) Desconto INSS \n"
				+ "13) Sua Idade \n"
				+ "14) Empréstimo \n"
				+ "15) Maior número \n"
				+ "16) Pirâmide \n"
				+ "17) Supermercado \n"
				+ "18) Margem Empresa \n"
				+ "19) Solução Financeira \n"
				+ "20) Ordem Decrescente \n"
				+ "21) Geração de Arquivo \n";
		int nMetodo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
		return nMetodo;
	}
	
	
	public static void calculoMedia() {
		List<Float> listaNotas = new ArrayList<Float>();
		float valor = 0f;
		int contLoop = 0;
		boolean continuar = true;
		while (continuar) {
			valor = formatacao.ConvertStringToFloat(JOptionPane.showInputDialog("Informe o valor"));
			listaNotas.add(valor);
			valor = 0f;
			contLoop = JOptionPane.showConfirmDialog(null, "Deseja informar mas algum valor ?");
			if (contLoop > 0) {
				continuar = false;
			}
		}
		float media = formatacao.ReturnMedia(listaNotas);
		JOptionPane.showMessageDialog(null, "Sua média foi: " + Formatacao.formatFloatStringOutras(media) + "");
	}
	
	
	public static void calculoEscolar() {
		List<Float> listaNotas = new ArrayList<Float>();
		float valor = 0f;
		int contLoop = 0;
		boolean continuar = true;
		float nMedia = 0f;
		while (continuar) {
			valor = formatacao.ConvertStringToFloat(JOptionPane.showInputDialog("Informe sua nota"));
			listaNotas.add(valor);
			valor = 0f;
			contLoop = JOptionPane.showConfirmDialog(null, "Deseja informar mas algum valor ?");
			if (contLoop > 0) {
				continuar = false;
			}
		}
		nMedia = formatacao.ConvertStringToFloat(JOptionPane.showInputDialog("Informe a média de aprovação"));
		JOptionPane.showMessageDialog(null, formatacao.schoolCalculation(listaNotas, nMedia));
	}
	
	
	public static void descontoCarro() {
		List<Carro> listaCarro = new ArrayList<Carro>();
		int contador2000 = 0;
		int contadorGeral = 0;
		Carro carro = null;
		boolean continuar = true;
		String mensagem = "";
		while (continuar) {
			carro = new Carro();
			carro.setValorCarro(formatacao.ConvertStringToFloat(JOptionPane.showInputDialog("Informe o valor do carro")));
			carro.setDescontoCarro(formatacao.ConvertStringtoInteger(JOptionPane.showInputDialog("Informe o ano do carro")));
			if (carro.getDescontoCarro() > 2000) {
				contadorGeral = contadorGeral ++;
				carro.setValorDesconto(7);
				float desconto = carro.getValorCarro() * 0.07f;
				carro.setValorLiquido(carro.getValorCarro() - desconto);
			}else {
				carro.setValorDesconto(12);
				float desconto = carro.getValorCarro() * 0.12f;
				carro.setValorLiquido(carro.getValorCarro() - desconto);
				contador2000 = contador2000 + 1;
			}
			contadorGeral = contadorGeral + 1;
			listaCarro.add(carro);
			int contLoop = JOptionPane.showConfirmDialog(null, "Deseja informar mas algum valor ?");
			if (contLoop > 0) {
				continuar = false;
			}
		}
		mensagem = mensagem 
				+ " N° Carros: " + contadorGeral + " ---------- N° Carros ano 2000: " + contador2000 + " \n";
		for (int i = 0; i < listaCarro.size(); i++) {
			mensagem = mensagem 
							+ " ----------------------- \n"
							+ "Valor do carro: R$" + Formatacao.formatFloatStringOutras(listaCarro.get(i).getValorCarro()) + "; ----- Ano Carro: " + listaCarro.get(i).getDescontoCarro() + "; \n"
									+ "Desconto: " + Formatacao.formatFloatStringOutras(listaCarro.get(i).getValorDesconto()) 
									+ "% ----- Valor total: R$" + Formatacao.formatFloatStringOutras(listaCarro.get(i).getValorLiquido()) + "; \n";
		}
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	
	public static void calculoSomar() {
		float n1 = Float.parseFloat(JOptionPane.showInputDialog("Informe o primeiro valor"));
		float n2 = Float.parseFloat(JOptionPane.showInputDialog("Informe o segundo valor"));
		float total = n1 + n2;
		JOptionPane.showMessageDialog(null, "A soma de " + Formatacao.formatFloatStringOutras(n1)
						+ " + " + Formatacao.formatFloatStringOutras(n2) + " é de: " +  Formatacao.formatFloatStringOutras(total));
	}
	
	
	
	public static void calculoSomatoria() {
		float n1 = Float.parseFloat(JOptionPane.showInputDialog("Informe o primeiro valor"));
		float n2 = Float.parseFloat(JOptionPane.showInputDialog("Informe o segundo valor"));
		JOptionPane.showMessageDialog(null, "A soma dos números é de: " +  (n1+n2) + "\n"
								+ "---------- \n"
								+ "A subtração dos números é de: " + (n1-n2) + " \n"
										+ "----------- \n"
										+ "A multiplicação dos números é de: " + (n1*n2) + " \n"
												+ "---------- \n"
												+ "A divisão dos números é de: " + (n1/n2));
	}
	
	
	
	public static void calculadoraBasica() {
		float n1 = Float.parseFloat(JOptionPane.showInputDialog("Informe o primeiro valor"));
		float n2 = Float.parseFloat(JOptionPane.showInputDialog("Informe o segundo valor"));
		int operacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a operação que deseja fazer: \n \n"
				+ "1 - SOMA \n 2 - SUBTRAÇÃO \n 3 - MULTIPLICAÇÃO \n 4 - DIVISÃO"));
		switch (operacao) {
		case 1:
			JOptionPane.showMessageDialog(null,(n1+n2));
			break;
		case 2:
			JOptionPane.showMessageDialog(null, (n1-n2));
			break;
		case 3:
			JOptionPane.showMessageDialog(null, (n1*n2));
			break;
		case 4:
			JOptionPane.showMessageDialog(null, (n1/n2));
			break;
		default:
			JOptionPane.showMessageDialog(null, "Operação invalida!!!");
			break;
		}
	}
	
	
	public static void calculadora4() {
		float n1 = Float.parseFloat(JOptionPane.showInputDialog("Informe o primeiro valor"));
		float n2;
		if (formatacao.validarCalculadora4(n1)) {
			n2 = Float.parseFloat(JOptionPane.showInputDialog("Informe o segundo valor"));
			if (formatacao.validarCalculadora4(n2)) {
				int operacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a operação que deseja fazer: \n \n"
						+ "1 - SOMA \n 2 - SUBTRAÇÃO \n 3 - MULTIPLICAÇÃO \n 4 - DIVISÃO"));
				switch (operacao) {
					case 1:
						JOptionPane.showMessageDialog(null,(n1+n2));
						break;
					case 2:
						JOptionPane.showMessageDialog(null, (n1-n2));
						break;
					case 3:
						JOptionPane.showMessageDialog(null, (n1*n2));
						break;
					case 4:
						JOptionPane.showMessageDialog(null, (n1/n2));
						break;
					default:
						JOptionPane.showMessageDialog(null, "Operação invalida!!!");
						break;
				}
				int continuar = JOptionPane.showConfirmDialog(null, "Deseja efetuar uma nova operação ?");
				if (continuar == 0) {
					calculadora4();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Favor informar valor somente de 0 a 4");
				calculadora4();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Favor informar valor somente de 0 a 4");
			calculadora4();
		}
	}
	
	
	public static void calculoMediaSalario() {
		float valorTotal = 0f;
		float media = 0f;
		int replicaSalario;
		int qFuncionario = formatacao.ConvertStringtoInteger(JOptionPane.showInputDialog("Informe o número de funcionários"));
		replicaSalario = JOptionPane.showConfirmDialog(null, "Salário dos funcionarios são todos iguais?");
		if (replicaSalario == 0) {
			valorTotal = formatacao.ConvertStringToFloat(JOptionPane.showInputDialog("Informe o salario dos funcionários"));
			valorTotal = valorTotal * qFuncionario;
		}else {
			for (int i = 0; i < qFuncionario; i++) {
				valorTotal = valorTotal +  formatacao.ConvertStringToFloat(JOptionPane.showInputDialog("Informe o salario do funcionário: " + (i + 1)));
			}
		}
		media = valorTotal/qFuncionario;
		JOptionPane.showMessageDialog(null, "A média de salario é de R$" + Formatacao.formatFloatStringOutras(media));
	}
	
	
	public static void retornarMes() {
		int nMes = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do mês desejado"));
		if (nMes <= 0 || nMes > 12) {
			JOptionPane.showInputDialog(formatacao.retornarNomeMes(nMes));
		}else {
			JOptionPane.showInputDialog(nMes + " = " + formatacao.retornarNomeMes(nMes));
		}
	}
	
	
	public static void investimentoJuros(){
		float valorBruto = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor bruto"));
		float juros = Formatacao.jurosInvestimento(Integer.parseInt(JOptionPane.showInputDialog("Informe a opções de investimento: \n1- Poupança \n2- Selic \n3- Tesouro \n4- Bolsa")));
		float rendimento = valorBruto * (juros/100);
		float valorLiquido = valorBruto + rendimento;
		JOptionPane.showMessageDialog(null, "Valor Bruto: R$" + Formatacao.formatFloatStringOutras(valorBruto) + " + Juros: " + Formatacao.formatFloatStringOutras(juros) + "% \n"
				+ "Rendimento: R$" + Formatacao.formatFloatStringOutras(rendimento) + "\nValor Liquido: R$" + Formatacao.formatFloatStringOutras(valorLiquido));
	}
	
	
	public static void planoSaude() {
		String nome = JOptionPane.showInputDialog("Informe seu nome");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe sua idade"));
		float valorPlano;
		if (idade >=0 && idade <= 10) {
			valorPlano = 30;
		}else if(idade > 10 && idade <=29) {
			valorPlano = 60;
		}else if(idade > 29 && idade <=45) {
			valorPlano = 120;
		}else if(idade > 45 && idade <=59) {
			valorPlano = 150;
		}else if(idade > 59 && idade <= 65) {
			valorPlano = 250;
		}else if (idade > 65) {
			valorPlano = 400;
		}else {
			valorPlano = 0;
		}
		if (valorPlano == 0) {
			JOptionPane.showMessageDialog(null, "Informe um valor valido para sua idade");
		}else {
			JOptionPane.showMessageDialog(null, "Nome: "+ nome +" \nSeu plano é de R$" + Formatacao.formatFloatStringOutras(valorPlano));
		}
	}
	
	

	public static void descontoInss() {
		float valorBruto = Float.parseFloat(JOptionPane.showInputDialog("Informe seu salário"));
		float desconto = 0;
		if(valorBruto > 600 && valorBruto <=1200) {
			desconto = 0.2f;
		}else if(valorBruto > 1200 && valorBruto <= 2000){
			desconto = 0.25f;
		}else if(valorBruto > 2000) {
			desconto = 0.3f;
		}
		JOptionPane.showMessageDialog(null, "R$" + Formatacao.formatFloatStringOutras(valorBruto) + 
				" - " + Formatacao.formatFloatStringOutras((desconto * 100)) + "% = R$" + Formatacao.formatFloatStringOutras((valorBruto - (valorBruto * desconto))));
	
	
	}
	
	
	public static void descobrirIdade() {
		int anoNasc;
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Deseja qual informação? \n1- Idade \n2- Ano Nascimento                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 "));
		if (opcao == 1) {
			anoNasc = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do seu nascimento"));
			int anoAtual = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano desejado"));
			JOptionPane.showMessageDialog(null, "Sua idade em " + anoAtual + " é de: " + (anoAtual - anoNasc));
		}else {
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a sua idade!!"));
			int aniversario = JOptionPane.showConfirmDialog(null, "Já fez aniversário este ano?");
			if (aniversario == 1) {
				idade = idade + 1;
			}
			Calendar dataAtual = Calendar.getInstance();
			anoNasc = dataAtual.get(Calendar.YEAR) - idade;
			JOptionPane.showMessageDialog(null, "Você nasceu em: " + anoNasc);
		}
	}
	
	
	public static void emprestimos() {
		float valorBruto = Float.parseFloat(JOptionPane.showInputDialog("Informe seu salario bruto"));
		float descontos = Float.parseFloat(JOptionPane.showInputDialog("Informe valor das suas despesas"));
		float valorEmprestimo = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor do seu empréstimo"));
		float valorLiquido = valorBruto - descontos;
		if (valorEmprestimo <= (valorLiquido * 0.3)) {
			JOptionPane.showMessageDialog(null, "Valor de empréstimo aprovado");
		}else {
			JOptionPane.showMessageDialog(null, "Infelizmente o valor do seu empréstimo não foi aprovado");
		}
	}
	
	
	public static void mediaIdade() {
		boolean continuar = true;
		List<Integer> listaIdade = new ArrayList<Integer>();
		int maiorIdade = 0;
		int menorIdade = 0;
		int mediaIdade = 0;
		int contadorMaior = 0;
		int somaIdade = 0;
		while(continuar) {
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe sua idade"));
			if (idade >= 18) {
				contadorMaior = contadorMaior + 1;
			}
			if (maiorIdade < idade) {
				maiorIdade = idade;
			}
			if (menorIdade >= idade) {
				menorIdade = idade;
			}
			somaIdade = somaIdade + idade;
			listaIdade.add(idade);
			int contLoop = JOptionPane.showConfirmDialog(null, "Deseja informar outra idade ?");
			if (contLoop > 0) {
				continuar = false;
			}
		}
		mediaIdade = somaIdade/listaIdade.size();
		JOptionPane.showMessageDialog(null, "Número total de pessoas: " + listaIdade.size() + "; \n Média de idade: " + mediaIdade + "; \n A maior idade: " + maiorIdade);
	}
	
	
	
	public static void maiorNumero() {
		float maiorNum;
		boolean iguais = false;
		float num1 = Float.parseFloat(JOptionPane.showInputDialog("Informe o primeiro número:"));
		maiorNum = num1;
		float num2 = Float.parseFloat(JOptionPane.showInputDialog("Informe o segundo número:"));
		if (maiorNum < num2) {
			maiorNum = num2;
		}else if (maiorNum == num2) {
			iguais = true;
		}
		float num3 = Float.parseFloat(JOptionPane.showInputDialog("Informe o terceiro número:"));
		if (maiorNum < num3) {
			maiorNum = num3;
			iguais = false;
		}else if (maiorNum == num3) {
			iguais = true;
		}
		if (iguais) {
			JOptionPane.showMessageDialog(null, "Número iguais!!!");
		}else {
			JOptionPane.showMessageDialog(null, "O maior número informado é: " + maiorNum);
		}
	}
	
	
	public static void piramide() {
		int linhas = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de linhas:"));
		String desenho = "";
		for (int i = 1; i <= linhas; i++) {
			for (int j = 0; j < i; j++) {
				desenho = desenho + "*";
			}
			desenho = desenho + " \n";
			 
		} 
		JOptionPane.showMessageDialog(null, "Sua Pirâmide: \n" + desenho);
	}
	
	
	public static void supermercado() {
		List<Supermercado> listaSupermercado = new ArrayList<Supermercado>();
		boolean continua = true;
		int debcred;
		int tipoPagamento = 0;
		float TotalCompra = 0;
		float totalParcela = 0;
		int nParcela = 0;
		int estacionamento;
		boolean contForma = true;
		while (continua) {
			Supermercado supermercado = new Supermercado();
			supermercado.setNomeProduto(JOptionPane.showInputDialog("Informe o nome do produto"));
			supermercado.setValorProduto(Float.parseFloat(JOptionPane.showInputDialog("Informe o valor do produto")));
			TotalCompra = TotalCompra + supermercado.getValorProduto();
			listaSupermercado.add(supermercado);
			int conf = JOptionPane.showConfirmDialog(null, "Informar outro produto ?");
			if (conf > 0) {
				continua = false;
			}
		}
		do {
			debcred = Integer.parseInt(JOptionPane.showInputDialog("Total da compra: R$ "+ TotalCompra +" \n \n Forma de Pagamento: (Digite o número) \n 1) Débito \n 2) Crédito"));
			if (debcred < 1 || debcred > 2) {
				JOptionPane.showMessageDialog(null, "Forma de Pagamento Inválida!!!");
				contForma = true;
			}else {
				contForma = false;
			}
		} while (contForma);
		int finalizar;
		do {
			finalizar = JOptionPane.showConfirmDialog(null, "Insira seu cartão!!");
			if (finalizar > 0) {
				JOptionPane.showMessageDialog(null, "Informe um cartão válido!!");
			}
		} while (finalizar > 0);
		if (debcred == 2) {
			do {
				tipoPagamento = Integer.parseInt(JOptionPane.showInputDialog("Tipo de Pagamento: (Digite o número) \n 1) A Vista \n 2) Parcelado"));
				if (tipoPagamento < 1 || tipoPagamento > 2) {
					JOptionPane.showMessageDialog(null, "Tipo de Pagamento Inválida!!!");
					contForma = true;
				}else {
					contForma = false;
				}
			} while (contForma);
			if (tipoPagamento == 2) {
				nParcela = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de parcelas!!"));
				totalParcela = TotalCompra / nParcela;
			}
		}
		estacionamento = JOptionPane.showConfirmDialog(null, "Cupom de estacionamento ? ");
		if (estacionamento == 0) {
			JOptionPane.showInputDialog("Digite o seu cupom para validação!!");
		}
		JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!! \n \n Confirme novamente para emissão da nota eletronica \n \n Obrigado pela preferência!!");
		JOptionPane.showMessageDialog(null, impressaoNotaSuper(listaSupermercado, tipoPagamento, nParcela, TotalCompra, totalParcela, debcred));
	}
	
	
	
	public static String impressaoNotaSuper(List<Supermercado> listaSuper, int tipoPagamento, int nParcela, float totalCompra, float valorParcela, int formaPagamento) {
		String mensagem = "Super Mercado Economize \n DATA: " + Formatacao.ConvercaoDataPadrao(new Date()) + " \n \n";
		mensagem = mensagem + "Listagem de produtos: \n \n --------------------------------------- \n ";
		for (int i = 0; i < listaSuper.size(); i++) {
			mensagem = mensagem + i + ") " + listaSuper.get(i).getNomeProduto() + " -- R$ " + listaSuper.get(i).getValorProduto() + "\n"; 
		}
		mensagem = mensagem + "\n --------------------------------------- \n Formas de Pagamento \n Total da compra R$ " + totalCompra + "\n \n --------------------------------------- \n";
		if (formaPagamento == 1) {
			mensagem = mensagem + "\n Débito";
		}else {
			mensagem = mensagem + "\n Crédito";
		}
		if (tipoPagamento == 2) {
			mensagem = mensagem + "\n N° Parcelas: " + nParcela + "\n Valor da parcela R$ " + valorParcela;
		}
		return mensagem;
	}
	
	
	public static void margemEmpresa() {
		String nomeEmpresa = "";
		int nPerspectiva = 0;
		float valorProdutoMensal = 0f;
		float valorProdutoAnual = 0f;
		float valorComissao = 0f;
		int mesInicio = 0;
		int mesFinal = 0;
		int mesResultado = 0;
		float valorInvestimento = 0f;
		float valorRetorno = 0f;
		String nomeMesInicio = "";
		String nomeMesFinal = "";
		int quantidadeProduto = 0;
		float valorProduto = 0;
		float valorInvestimentoMensal = 0f;
		nomeEmpresa = JOptionPane.showInputDialog("Informe o nome da sua empresa");
		mesInicio = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês de inicio"));
		mesFinal = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês final"));
		mesResultado = mesFinal - mesInicio;
		nomeMesInicio = formatacao.retornarNomeMes(mesInicio);
		nomeMesFinal = formatacao.retornarNomeMes(mesFinal);
		nPerspectiva = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de margem: \n1) Valor total \n2) Valor por produto"));
		if (nPerspectiva == 1) {
			valorProdutoAnual = Float.parseFloat(JOptionPane.showInputDialog("Qual valor total esperado ?"));
			valorProdutoMensal = valorProdutoAnual/mesResultado;
			valorInvestimento = valorProdutoAnual/2;
			valorProdutoMensal = valorInvestimento/mesResultado;
			valorRetorno = valorProdutoAnual*0.7f;
			valorComissao = valorProdutoAnual*0.3f;
		}else {
			valorProduto = Float.parseFloat(JOptionPane.showInputDialog("Qual valor média do produto ?"));
			quantidadeProduto = Integer.parseInt(JOptionPane.showInputDialog("Quantidade da venda dos produtos esperado mensal ?"));
			valorProdutoMensal = valorProduto * quantidadeProduto;
			valorProdutoAnual = valorProdutoMensal * mesResultado;
			valorInvestimento = valorProdutoAnual/2;
			valorProdutoMensal = valorInvestimento/mesResultado;
			valorRetorno = valorProdutoAnual*0.7f;
			valorComissao = valorProdutoAnual*0.3f;
		}
		JOptionPane.showMessageDialog(null, "---FATURAMENTO--- \nNome da empresa: " + nomeEmpresa
				+"\n\nMeses: " + nomeMesInicio + " - " + nomeMesFinal 
				+"\nFAturamento anual: R$ " + Formatacao.formatFloatStringOutras(valorProdutoAnual)
				+"\nFaturamento mensal: R$ " + Formatacao.formatFloatStringOutras(valorProdutoMensal)
				+"\nValor de investimento anual: R$ " + Formatacao.formatFloatStringOutras(valorInvestimento)
				+"\nValor de investimento mensal: R$ " + Formatacao.formatFloatStringOutras(valorInvestimentoMensal)
				+"\nValor de reotorno: R$ " + Formatacao.formatFloatStringOutras(valorRetorno)
				+"\nValor de comissão: R$ " + Formatacao.formatFloatStringOutras(valorComissao));
	}
	
	
	public static void solucaoFinanceira() {
		float valorBruto = 0f;
		float valorDivida = 0f;
		float porcentagemLiquida = 0f;
		float resultadoPorcentagem = 0f;
		float meses = 0f;
		valorBruto = Float.parseFloat(JOptionPane.showInputDialog("Informe o seu valor bruto mensal!!"));
		porcentagemLiquida = Integer.parseInt(JOptionPane.showInputDialog("Qual a porcentagem de seu valor bruto para as dividas?"));
		resultadoPorcentagem = porcentagemLiquida/100;
		resultadoPorcentagem = resultadoPorcentagem * valorBruto;
		valorDivida = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor total de sua divida!!"));
		meses = valorDivida/resultadoPorcentagem;
		JOptionPane.showMessageDialog(null, "Saldo para pagamento por mês R$ " + resultadoPorcentagem + 
				"\nQuantos meses para quitação: " + meses);
	}
	
	
	public static void ordemDecrescente() {
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um número maior que 0!!"));
		String mensagem = "Ordem decrescente: \n";
		int decrescente = numero;
		for (int i = 0; i <= numero; i++) {
			mensagem = mensagem + decrescente + "\n";
			decrescente = decrescente - 1;
		}
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	
	 public static void gravarArquivo() {
		 String pasta = JOptionPane.showInputDialog("Informe o caminho até a pasta desejada!! \nInforme com a expressão '/'");
		 pasta = pasta + "/" + JOptionPane.showInputDialog("Informe um nome para o novo arquivo!!");
		 String conteudo = JOptionPane.showInputDialog("Digite o conteúdo do arquivo");
		 try {
			ManipuladorArquivo.escritor(pasta, conteudo);
			ManipuladorArquivo.leitor(pasta);
			JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso");
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	
	
	
	
	

	
	
	
	
	
	
	

}
