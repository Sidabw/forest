package com.beta.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.codec.binary.Base64;


public class PhantomjsFactory {
	private static PhantomjsFactory phantomjs;
	
	public static final String URL="http://127.0.0.1:8080/echarts3 ";
	public static final String JS_PATH="D:/phantomjs/jstest/c.js ";
	public static final String datalist = "[5,20,36,10,10,20]";
	
	private PhantomjsFactory(){
		System.out.println("noargsConstructor in");
	};
	
	public synchronized static PhantomjsFactory getInstance(){
		if(phantomjs==null){
			phantomjs = new PhantomjsFactory();
			return phantomjs;
		}else{
			return phantomjs;
		}
	}
	public boolean produceImage(List<String> phantomjsData) throws Exception{
		//数据格式处理
		String dataFormated = dataFormatHandling(phantomjsData);
		Runtime runtime = Runtime.getRuntime();
		//Process process = runtime.exec("phantomjs "+JS_PATH+URL);
		//直接传字符串会造成数据显示不全
		Process process = runtime.exec("phantomjs "+JS_PATH+URL+dataFormated);
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
		return false;
	}
	private String dataFormatHandling(List<String> phantomjsData){
		StringBuffer dataFormated = new StringBuffer();
		//phantomjsData.forEach(e ->{dataFormated.append(e+Const.TRS_SEPARATOR);});
		for (int i = 0; i < phantomjsData.size(); i++) {
			if(i==(phantomjsData.size()-1)){
				dataFormated.append(phantomjsData.get(i));
			}else{
				dataFormated.append(phantomjsData.get(i));
			}
		}
		return dataFormated.toString();
	}
}
