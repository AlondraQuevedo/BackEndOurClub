package com.generation.ourClub.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtils {
	public static String salt="";
	public static String createHash(String value) {
		String res= "";
		value+=salt;
		try {
			MessageDigest md =MessageDigest.getInstance("Sha-256");
			md.update(value.getBytes());
			byte[] resultado=md.digest();
			int max=resultado.length;
			String tmp;
			for (int i=0; i<max; i++) {
	             tmp = Integer.toHexString(0xFF & resultado[i]);
	             res += (tmp.length()<2)?0+tmp:tmp;
	         }// for i

		}catch(NoSuchAlgorithmException e) {
			System.out.println(e.toString());
			
		}//catch
		
		return res;
		
	}//create Hash
	
	public static boolean verifyHash(String original,String hash) {
		String res=createHash(original);
		return res.equalsIgnoreCase(hash);
	}//VERYFY
	
//	public static void main(String[] args) {
//		System.out.println(createHash("1234Marco*"));
//	}
	

}//class sahutils
