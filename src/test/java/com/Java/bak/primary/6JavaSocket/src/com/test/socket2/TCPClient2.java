package com.test.socket2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TCPClient2 {
	public static void main(String[] args) {
		try {
			Socket socket  =new Socket("127.0.0.1",9999);
			InputStream in=socket.getInputStream();
			DataInputStream dis=new DataInputStream(in);
			System.out.println(dis.readUTF());
			dis.close();
			socket.close();
			
		} catch (ConnectException e) {
			// TODO: handle exception
			System.out.println("¡¨Ω” ß∞‹£°£°£°");
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
