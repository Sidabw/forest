package com.test.socket;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		//监听6666端口
		ServerSocket serverSocket= new ServerSocket(6666);
		while(true)
		{
			//调用accept，接受客户端的连接
			Socket ss=serverSocket.accept();
			//建立输入流，准备接受ss上的数据
			DataInputStream dis= new DataInputStream(ss.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			ss.close();
		}
	}
}
