package br.senai.sc.tii2014n1.inovagames.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.openqa.selenium.internal.Base64Encoder;




public class Criptografia {
	
	private static MessageDigest messageDigest;
	private static Base64Encoder encoder;
  
	public static String encript(String value) throws NoSuchAlgorithmException{
		if (messageDigest == null || messageDigest.getAlgorithm() != "SHA-256") {
			messageDigest = MessageDigest.getInstance("SHA-256");
		}

		if (encoder == null) {
			encoder = new Base64Encoder();
		}
		
	    byte[] hash = messageDigest.digest(value.getBytes());
	    return encoder.encode(hash);
	}
}
