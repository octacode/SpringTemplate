  public static void main(String[] args) throws Exception {
	        String key = "12345";
	        String clean = "223abnchj";
	        
	        String encrypted = encrypt(clean, key);
	        System.out.println(encrypted.toString());
	        String decrypted = decrypt(encrypted, key);
	        System.out.println(decrypted);
	    }
