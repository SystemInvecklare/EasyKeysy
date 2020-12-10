package com.github.systeminvecklare.easykeysy;

import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class SecretMessage {
	private static final int AES_KEY_SIZE = 16;
	
	private final byte[] rsaEncryptedAesKey;
	private final byte[] aesEncryptedData;
	
	private SecretMessage(byte[] rsaEncryptedAesKey, byte[] aesEncryptedData) {
		this.rsaEncryptedAesKey = rsaEncryptedAesKey;
		this.aesEncryptedData = aesEncryptedData;
	}

	public static SecretMessage makeSecret(String publicKey, byte[] data) {
		try {
			KeyGenerator aesGenerator = KeyGenerator.getInstance("AES");
			aesGenerator.init(AES_KEY_SIZE*Byte.SIZE); // The AES key size
			SecretKey secretKey = aesGenerator.generateKey();
			
			Cipher aesCipher = Cipher.getInstance("AES");
			aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] aesEncodedData = aesCipher.doFinal(data);

			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64Helper.decode(publicKey));
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			
	        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	    	rsaCipher.init(Cipher.ENCRYPT_MODE, keyFactory.generatePublic(publicKeySpec));
	    	
	    	byte[] rsaEncryptedAesKey = rsaCipher.doFinal(secretKey.getEncoded());
		    	
			return new SecretMessage(rsaEncryptedAesKey, aesEncodedData);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public byte[] decode(String privateKey) {
		try {
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64Helper.decode(privateKey));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, keyFactory.generatePrivate(privateKeySpec));
			
			byte[] recoveredAesKey = cipher.doFinal(rsaEncryptedAesKey);
			
			SecretKey sectetKey = new SecretKeySpec(recoveredAesKey , 0, recoveredAesKey.length, "AES");
			
			Cipher aesCipher = Cipher.getInstance("AES");
			aesCipher.init(Cipher.DECRYPT_MODE, sectetKey);
			return aesCipher.doFinal(aesEncryptedData);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String base64Key = Base64Helper.encode(rsaEncryptedAesKey);
		builder.append(base64Key.length()).append(";");
		builder.append(base64Key);
		builder.append(Base64Helper.encode(aesEncryptedData));
		return builder.toString();
	}
	
	public static SecretMessage fromString(String stringRepresentation) {
		int keyLengthData = stringRepresentation.indexOf(";");
		int keyLength = Integer.parseInt(stringRepresentation.substring(0, keyLengthData));
		String base64EncodedKey = stringRepresentation.substring(keyLengthData+1, keyLengthData+1+keyLength);
		String base64EncodedData = stringRepresentation.substring(keyLengthData+1+keyLength);
		return new SecretMessage(Base64Helper.decode(base64EncodedKey), Base64Helper.decode(base64EncodedData));
	}
}
