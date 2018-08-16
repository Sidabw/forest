
package com.beta.phantom;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.commons.codec.binary.Base64;

/***
 * 1.use ngnix to reflect index.html from desktop/chart on 8010 port.
 * 2.
 *
 */
public class Phantom {
	public static final String URL="http://127.0.0.1:8010 ";
	public static final String JS_PATH="D:/phantomjs/jstest/c.js ";
//	public static final String JS_PATH="/usr/local/phantomjs-2.1.1-linux-i686/jstest/c.js ";
	public static final String datalist = "5,20,36,10,10,20";
	public static void doPhantomjs() throws Exception{
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("phantomjs "+JS_PATH+URL);
//		Process process = runtime.exec("phantomjs "+JS_PATH+URL+datalist);
		InputStream inputStream = process.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer str  =  new StringBuffer();
		int a= 0;
		while((a=bufferedReader.read())!=-1){
			str.append((char)a);
		}
		System.out.println(str.toString());
		
		Base64 base64 = new Base64();
		byte[] decode = base64.decode(str.toString());
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("12.png"));
		byte[] temp=new byte[1024];
		int read=0;
		while((read = bufferedInputStream.read(temp))!=-1){
			bufferedOutputStream.write(temp,0,read);
		}
		bufferedOutputStream.close();
		
		
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("11.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		bufferedWriter.write(str.toString());
		bufferedWriter.close();
	}
}
