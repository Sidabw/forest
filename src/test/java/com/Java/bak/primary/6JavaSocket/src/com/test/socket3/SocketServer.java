package com.test.socket3;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) {
		try {

		//	while (true) {
				ServerSocket serverSocket = new ServerSocket(8201);
				Socket s = serverSocket.accept();

				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				String str = null;
				if ((str = dis.readUTF()) != null) {
					System.out.println("服务器端读到的内容" + str);
					System.out.println("from	" + s.getInetAddress());
					System.out.println("port	" + s.getPort());
				}
				dos.writeUTF("hi myClient");
				dos.close();
				dis.close();
				s.close();
		//	}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
