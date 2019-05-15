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
 *  Properties(�����ļ���)����Ҫ�����������úͶ�ȡ�����ļ�����Ϣ
 *  
 *  	ע��ϸ�ڣ�
 *  		1.��������ļ������ʹ�������ģ����������ļ�ʱֻ��ʹ��store��Writer Writer,String comments��
 * */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		readProperties();
	}
	//���������ļ�����Ϣ
	public static void creatProperties() throws IOException
	{
		//����Properties
		Properties properties=new Properties();
		properties.setProperty("zhangsan", "3");
		properties.setProperty("wangwu", "5");
		properties.setProperty("����", "6");
		//����Properties
		Set<Map.Entry<Object, Object>> entries=properties.entrySet();
		for(Entry<Object, Object> entry:entries)
		{
			System.out.println("����"+entry.getKey()+"  "+"ֵ��"+entry.getValue());
		}
		
		
		properties.store(new FileWriter("D:\\a.txt"), "hah");
	}
	//��ȡ�����ļ�����Ϣ
	public static void readProperties() throws IOException
	{
		Properties properties =new Properties();
		//���������ļ���Ϣ��Properties
		properties.load(new FileReader("D:\\a.txt"));
		Set<Map.Entry<Object, Object>> entries=properties.entrySet();
		for(Entry<Object, Object> entry:entries)
		{
			System.out.println("����"+entry.getKey()+"  "+"ֵ��"+entry.getValue());
		}
		properties.setProperty("����", "007");//���Properties�е����ݷ����˱仯�������������������ļ�
		properties.store(new FileWriter("D:\\a.txt"), "heh");
		
	}
}
