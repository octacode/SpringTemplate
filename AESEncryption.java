 package com.java.sp.eamp.util;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class AESEncryption {
	 private static final String AES_ENCRYPTION_KEY = "aesEncryptionKey";
	    private static final String INIT_VECTOR = "encryptionIntVec";
	    private static final String CHARSET_NAME= "UTF-8";

	    public static void main(String[] args) throws Exception {


	        String originalPassword ="c2d0WIeE";
	        String encryptedPassword = encrypt(originalPassword);
	        String decryptedPassword = decrypt(encryptedPassword);
	        System.out.println(encryptedPassword);
	        System.out.println(decryptedPassword);

	    }

	    public static String encrypt(String property) throws Exception {
	        try {

	            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(CHARSET_NAME));
	            SecretKeySpec skeySpec = new SecretKeySpec(AES_ENCRYPTION_KEY.getBytes(CHARSET_NAME), "AES");

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);  // Noncompliant because IV hard coded and cannot vary with each ciphering round
	            byte[] encryptedBytes = cipher.doFinal(property.getBytes(CHARSET_NAME));
	            return base64Encode(encryptedBytes); // IV is typically published

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }

	    private static String base64Encode(byte[] bytes) {
	        // NB: This class is internal, and you probably should use another impl base64Decode(property))
	        return new BASE64Encoder().encode(bytes);
	    }

	    public static String decrypt(String property) throws IOException {
	        try {

	            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(CHARSET_NAME));
	            SecretKeySpec skeySpec = new SecretKeySpec(AES_ENCRYPTION_KEY.getBytes(CHARSET_NAME), "AES");

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	            byte[] original = cipher.doFinal(base64Decode(property));

	            return new String(original);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	        return null;

	    }

	    private static byte[] base64Decode(String property) throws IOException {
	        // NB: This class is internal, and you probably should use another impl
	        return new BASE64Decoder().decodeBuffer(property);
	    }
}
