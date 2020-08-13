package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.md5util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {

	public static String HEXAndMd5(String plainText) {  
		   try {  
		     MessageDigest md = MessageDigest.getInstance("MD5");  
		     try {  
		       md.update(plainText.getBytes("UTF8"));  
		     } catch (UnsupportedEncodingException e) {  
		       e.printStackTrace();  
		     }  
		     byte b[] = md.digest();  
		     int i;  
		     StringBuffer buf = new StringBuffer(200);  
		     for (int offset = 0; offset < b.length; offset++) {  
		       i = b[offset] & 0xff;  
		       if (i < 16) buf.append("0");  
		       buf.append(Integer.toHexString(i));  
		     }  
		     return buf.toString();  
		   } catch (NoSuchAlgorithmException e) {  
		     //LoggerUtil.error("Md5加密异常", e);  
		     return null;  
		   }  
		 } 
	public static void main(String[] args){
		String encrypt=HEXAndMd5("sida");
		System.out.println(encrypt);
	}
}
