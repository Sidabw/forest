package com.test.udpsocket5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		 String str ="hello";
		 byte[] buf=str.getBytes();
		 DatagramPacket dp=new DatagramPacket(buf, buf.length,new InetSocketAddress("localhost",5678));//
		 //client端发送数据时的端口
		 DatagramSocket ds=new DatagramSocket(9999);
		 ds.send(dp);
		 ds.close();
	}
}
