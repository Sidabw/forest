
package com.widget.bak.phantom.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Demo2 {
	public static final String URL="http://127.0.0.1:8010/echarts3.html ";
	public static final String JS_PATH="D:/phantomjs/jstest/c.js ";
	public static final String datalist = "[5,20,36,10,10,20]";
	public static void main(String[] args) throws Exception{
		Runtime runtime = Runtime.getRuntime();
		//Process process = runtime.exec("phantomjs "+JS_PATH+URL);
		//直接传字符串会造成数据显示不全
		/*String strTemp = datalist.replace("[", "");
		strTemp = strTemp.replace("]", "");*/
		Process process = runtime.exec("phantomjs "+JS_PATH+URL+"helloworld");
		InputStream inputStream = process.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer str  =  new StringBuffer();
		int a= 0;
		while((a=bufferedReader.read())!=-1){
			str.append((char)a);
		}
		//System.out.println(str.toString());
		
		//String[] split = str.toString().split("#TRS#");
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("11.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		//bufferedWriter.write(split.length);
		//for(String str2 : split){
			bufferedWriter.newLine();
			bufferedWriter.write(str.toString());
		//}
		bufferedWriter.close();
		/*for(int i = 0;i < 5;i ++){
			Base64 base64 = new Base64();
			byte[] decode = base64.decode(split[i]);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(i+".png"));
			byte[] temp=new byte[1024];
			int read=0;
			while((read = bufferedInputStream.read(temp))!=-1){
				bufferedOutputStream.write(temp,0,read);
			}
			bufferedOutputStream.close();
		}*/
	}
}
