package com.widget.phantom.demo;

import java.io.*;
import java.util.List;

/***
 * This class was designed for report module which has specific data type, but it ends up being abandoned .-，-
 * You can use this class for reference.
 */
public class PhantomjsFactory {
	private static PhantomjsFactory phantomjs;
	
	public static final String URL="http://192.168.200.5:9111/index.html ";
	public static final String JS_PATH="/home/trs/phantomjs/phantomjs4netinsight.js ";
	
	private PhantomjsFactory(){};
	
	public synchronized static PhantomjsFactory getInstance(){
		if(phantomjs==null){
			phantomjs = new PhantomjsFactory();
			return phantomjs;
		}else{
			return phantomjs;
		}
	}
	public String[] produceImage(List<String> phantomjsData) throws Exception{
		//数据格式处理
		String dataFormated = dataFormatHandling(phantomjsData);
		Runtime runtime = Runtime.getRuntime();
		//Process process = runtime.exec("phantomjs "+JS_PATH+URL);
		Process process = runtime.exec("phantomjs "+JS_PATH+URL+dataFormated);
		InputStream inputStream = process.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer str  =  new StringBuffer();
		String a= "";
		while((a=bufferedReader.readLine())!=null){
			str.append(a);
		}
		// START	console to txt
		String[] split = str.toString().split("#TRS#");
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("D:/phantomjs/jstest/11.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		for(String str2 : split){
			bufferedWriter.newLine();
			bufferedWriter.write(str2);
		}
		bufferedWriter.close();
		//END
		//System.out.println(str.toString());
		String[] base64ImageArr = dataFormatHandling(str.toString());
		//System.out.println(base64ImageArr.length);
		return base64ImageArr;
	}
	private String dataFormatHandling(List<String> phantomjsData){
		StringBuffer dataFormated = new StringBuffer();
		for (int i = 0; i < phantomjsData.size(); i++) {
			if(i==(phantomjsData.size()-1)){
//				phantomjs 传输 " 有问题 只能传 '
				dataFormated.append(phantomjsData.get(i).replace('"', '\''));
			}else{
				dataFormated.append(phantomjsData.get(i).replace('"', '\'')+"#TRS#");
			}
		}
		return dataFormated.toString();
	}
	private String[] dataFormatHandling(String data){
		String[] split = data.split("#TRS#");
		return split;
	}
}
