package com.udp.test;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		long n =1000L;
		
		//�ֽ����������		�Զ�дlong�������ͽ��д���
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos =new DataOutputStream(baos);
		dos.writeLong(n);
		
		byte[] buf=baos.toByteArray();
		DatagramPacket dp =new DatagramPacket(buf, buf.length,new InetSocketAddress("localhost",2200));
		DatagramSocket ds =new DatagramSocket(9999);
		
		ds.send(dp);
		ds.close();
		
	}
}
