package com.test.socket;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		//����6666�˿�
		ServerSocket serverSocket= new ServerSocket(6666);
		while(true)
		{
			//����accept�����ܿͻ��˵�����
			Socket ss=serverSocket.accept();
			//������������׼������ss�ϵ�����
			DataInputStream dis= new DataInputStream(ss.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			ss.close();
		}
	}
}
