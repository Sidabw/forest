package com.test.conmunicationsocket4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient4 {
	public static void main(String[] args) throws Exception, IOException {
		//创建连接指定IP和端口的Socket对象
		 Socket s =new Socket("localhost", 2300);
		 //建立读取键盘上输入的内容的通道
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 String line=br.readLine();
		 
		 //建立读取服务器端发送的内容的通道
		 BufferedReader br2=new BufferedReader(new InputStreamReader(s.getInputStream()));
		 
		 //建立数据发送的通道
		 PrintWriter pw =new PrintWriter(s.getOutputStream());
		 
		 while(!line.equals("bye"))
		 {
			 //将读取到的键盘上输入的内容 输出到服务器
			 pw.println(line);
			 //刷新
			 pw.flush();
			 
			 System.out.println("Client...."+line);
			 
			 //控制台输出服务器端发送来的信息
			 System.out.println("Server..."+br2.readLine());
			 
			 //再从键盘读取下一行
			 line=br.readLine();		
		 }
//		 pw.close();
//		 br2.close();
		 br.close();
		 s.close();		//Socket 关掉之后，所有有关Socket的流就自动关掉了，包括PrintWriter BufferedReader
		 
	}
}
	