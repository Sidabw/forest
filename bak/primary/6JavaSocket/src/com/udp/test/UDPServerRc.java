package com.udp.test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		byte[] buf =new byte[1024*8];
		DatagramSocket ds = new DatagramSocket(2200);
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		while(true)
		{
			ds.receive(dp);
			
			ByteArrayInputStream bais =new ByteArrayInputStream(buf);
			DataInputStream dis =new DataInputStream(bais);
			System.out.println(dis.readLong());
		}
		
	}
}
