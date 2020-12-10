package com.github.systeminvecklare.easykeysy;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyPairGenerationUtil {
	public static Base64KeyPair createKeyPair() {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			KeyPair keyPair = generator.generateKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();
			String base64PublicKey = Base64Helper.encode(publicKey.getEncoded());
			String base64PrivateKey = Base64Helper.encode(privateKey.getEncoded());
			return new Base64KeyPair(base64PublicKey, base64PrivateKey);
		} catch (Exception e) {
			throw new RuntimeException("Failed to generate key pair", e);
		}
	}
}
