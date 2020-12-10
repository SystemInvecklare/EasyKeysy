package com.github.systeminvecklare.easykeysy;

import java.nio.charset.Charset;

public final class Decryptor {
	private final String privateKey;
	
	public Decryptor(String privateKey) {
		this.privateKey = privateKey;
	}

	public byte[] decrypt(SecretMessage secretMessage) {
		return secretMessage.decode(privateKey);
	}
	
	public String decrypt(SecretMessage secretMessage, Charset resultCharset) {
		return new String(decrypt(secretMessage), resultCharset);
	}
}
