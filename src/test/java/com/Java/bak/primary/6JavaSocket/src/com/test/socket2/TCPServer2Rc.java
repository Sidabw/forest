package com.test.socket2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket= new ServerSocket(9999);
			while(true)
			{
				Socket s=serverSocket.accept();
				DataOutputStream  di=new DataOutputStream(s.getOutputStream());
				di.writeUTF("hi");
				
				di.close();
				s.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
