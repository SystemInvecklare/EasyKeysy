package com.github.systeminvecklare.easykeysy;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Helper {
	private static final Charset BASE64_STRING_CHARSET = StandardCharsets.US_ASCII;
	
	public static String encode(byte[] data) {
		return new String(Base64.getEncoder().encode(data), BASE64_STRING_CHARSET);
	}
	
	public static String encode(String data, Charset charset) {
		return encode(data.getBytes(charset));
	}
	
	public static byte[] decode(String encoded) {
		return Base64.getDecoder().decode(encoded.getBytes(BASE64_STRING_CHARSET));
	}
	
	public static String decode(String encoded, Charset resultCharset) {
		return new String(decode(encoded), resultCharset);
	}
}
