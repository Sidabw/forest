package com.beta.basic.widgets.wx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {
	/**
	 * 验证签名
	 * @param signature
	 * @param timeStamp
	 * @param nonce
	 * */
	public static boolean checkSignature(String signature,String timeStamp,String nonce){
		String[] strs=new String[]{Constant.TOKEN,timeStamp,nonce};
		//对token signature timeStamp 进行字典排序.(只是进行字典排序)
		Arrays.sort(strs);
		
		StringBuilder content = new StringBuilder();
		for(int i=0;i<strs.length;i++){
			content.append(strs[i]);
		}
		String tmpStr=null;
		MessageDigest md=null;
		//1.加密获得字节数组2.该字节数组变回String3.该String与signature比较
		 try {
			 md = MessageDigest.getInstance("SHA-1");
			 byte[] digest = md.digest(content.toString().getBytes());
	         md = MessageDigest.getInstance("SHA-1");
	         tmpStr = byteToStr(digest);
	         System.out.println("HEX STR:"+tmpStr);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }

	        content = null;
	        // 将sha1加密后的十六进制字符串可与signature对比，标识该请求来源于微信
	        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}
	 /**
     * 将字节数组转换为十六进制字符串
     * 
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }
    /**
     * 将字节转换为十六进制字符串
     * 
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }

}
