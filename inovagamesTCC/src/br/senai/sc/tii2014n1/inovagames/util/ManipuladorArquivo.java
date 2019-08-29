package br.senai.sc.tii2014n1.inovagames.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {
	
	
	public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        buffRead.readLine();
        buffRead.close();
    }
 
    public static void escritor(String path, String linha) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }

}
