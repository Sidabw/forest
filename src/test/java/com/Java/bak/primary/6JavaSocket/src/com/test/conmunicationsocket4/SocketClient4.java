package com.test.conmunicationsocket4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient4 {
	public static void main(String[] args) throws Exception, IOException {
		//��������ָ��IP�Ͷ˿ڵ�Socket����
		 Socket s =new Socket("localhost", 2300);
		 //������ȡ��������������ݵ�ͨ��
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 String line=br.readLine();
		 
		 //������ȡ�������˷��͵����ݵ�ͨ��
		 BufferedReader br2=new BufferedReader(new InputStreamReader(s.getInputStream()));
		 
		 //�������ݷ��͵�ͨ��
		 PrintWriter pw =new PrintWriter(s.getOutputStream());
		 
		 while(!line.equals("bye"))
		 {
			 //����ȡ���ļ�������������� �����������
			 pw.println(line);
			 //ˢ��
			 pw.flush();
			 
			 System.out.println("Client...."+line);
			 
			 //����̨����������˷���������Ϣ
			 System.out.println("Server..."+br2.readLine());
			 
			 //�ٴӼ��̶�ȡ��һ��
			 line=br.readLine();		
		 }
//		 pw.close();
//		 br2.close();
		 br.close();
		 s.close();		//Socket �ص�֮�������й�Socket�������Զ��ص��ˣ�����PrintWriter BufferedReader
		 
	}
}
	