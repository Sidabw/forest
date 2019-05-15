package com.test.socket;
/*
 * TCP��UDP��HTTP��
 * TCPͨ��Э�顢UDPͨ��Э�鶼��TCP/IPЭ�����д�����е�����Э�顣��HTTPЭ������Ӧ�ò㣬����һ������������Ӧģʽ����״̬��Э�顣
 * TCPЭ��(���Ϳ���Э�飬Transmission Control Protocol)�����������ӵġ��˵��˵Ŀɿ�����Э�飬�߱�����ȷ�Ϻ������ش����ƣ��ܹ���֤���ݵ������ԡ�
 * UDPЭ�����û����ݱ�Э��(User Datagram Protocol)�����������ӵġ����ɿ��ģ�����为�����ı�TCPҪС�ܶࡣ
 * */
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
//ServerSocket��Socket���������Ӿ���TCP����
public class TCPClient {
	public static void main(String[] args) throws Exception{
		//1.����Socket������Ҫ���͵�Server�˵�ip��ַ�Ͷ˿ں�
		Socket socket=new Socket("127.0.0.1",6666);
		//2.����Socket.getOutputStreamд���������
		OutputStream os=socket.getOutputStream();
		
		DataOutputStream ds=new DataOutputStream(os);
		ds.writeUTF("hello world");
		ds.flush();
		ds.close();
		os.close();
		
	}
}
