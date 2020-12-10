package com.github.systeminvecklare.easykeysy;

import java.nio.charset.Charset;

public final class Encryptor {
	private final String publicKey;
	
	public Encryptor(String publicKey) {
		this.publicKey = publicKey;
	}

	public SecretMessage encrypt(byte[] data) {
		return SecretMessage.makeSecret(publicKey, data);
	}
	
	public SecretMessage encrypt(String data, Charset dataCharset) {
		return encrypt(data.getBytes(dataCharset));
	}
}
