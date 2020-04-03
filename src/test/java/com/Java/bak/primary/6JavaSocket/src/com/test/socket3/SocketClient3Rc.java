package com.test.socket3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient3 {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8201);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeUTF("Client output.");
			String str = null;
			if ((str = dis.readUTF()) != null) {
				System.out.println(str);
			}
			
			dos.close();
			dis.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
