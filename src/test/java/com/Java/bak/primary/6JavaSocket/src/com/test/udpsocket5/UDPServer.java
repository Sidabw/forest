package com.test.udpsocket5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		byte[] buf=new byte[1024];
		DatagramSocket ds=new DatagramSocket(5678);
		//���ܵ��������ֽ������װ�ŵ�����
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		while(true)
		{
			ds.receive(dp);
			
			System.out.println("length"+dp.getLength());
			//�������ֽ������������Ҫ��һ�顣
			System.out.println("content:"+new String(buf,0,dp.getLength()));
			
		}
	}
}
