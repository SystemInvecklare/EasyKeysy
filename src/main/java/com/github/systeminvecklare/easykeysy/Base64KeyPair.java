package com.github.systeminvecklare.easykeysy;

public final class Base64KeyPair {
	public final String publicKey;
	public final String privateKey;
	
	public Base64KeyPair(String publicKey, String privateKey) {
		this.publicKey = publicKey;
		this.privateKey = privateKey;
	}
}
