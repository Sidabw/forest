package com.io2readerwriter3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

/*
 *  Properties(配置文件类)：主要用于生成配置和读取配置文件的信息
 *  
 *  	注意细节：
 *  		1.如果配置文件中如果使用了中文，生成配置文件时只能使用store（Writer Writer,String comments）
 * */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		readProperties();
	}
	//保存配置文件的信息
	public static void creatProperties() throws IOException
	{
		//创建Properties
		Properties properties=new Properties();
		properties.setProperty("zhangsan", "3");
		properties.setProperty("wangwu", "5");
		properties.setProperty("罗蕾", "6");
		//遍历Properties
		Set<Map.Entry<Object, Object>> entries=properties.entrySet();
		for(Entry<Object, Object> entry:entries)
		{
			System.out.println("键："+entry.getKey()+"  "+"值是"+entry.getValue());
		}
		
		
		properties.store(new FileWriter("D:\\a.txt"), "hah");
	}
	//读取配置文件的信息
	public static void readProperties() throws IOException
	{
		Properties properties =new Properties();
		//加载配置文件信息到Properties
		properties.load(new FileReader("D:\\a.txt"));
		Set<Map.Entry<Object, Object>> entries=properties.entrySet();
		for(Entry<Object, Object> entry:entries)
		{
			System.out.println("键："+entry.getKey()+"  "+"值是"+entry.getValue());
		}
		properties.setProperty("罗蕾", "007");//如果Properties中的内容发生了变化，必须重新生成配置文件
		properties.store(new FileWriter("D:\\a.txt"), "heh");
		
	}
}
