package com.test.socket;
/*
 * TCP、UDP、HTTP：
 * TCP通信协议、UDP通信协议都是TCP/IP协议组中传输层中的两个协议。而HTTP协议属于应用层，塔是一个基于请求、响应模式的无状态的协议。
 * TCP协议(传送控制协议，Transmission Control Protocol)属于面向连接的、端到端的可靠传输协议，具备数据确认和数据重传机制，能够保证数据的完整性。
 * UDP协议是用户数据报协议(User Datagram Protocol)，它是无连接的、不可靠的，相对其负载消耗比TCP要小很多。
 * */
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
//ServerSocket与Socket建立的连接就是TCP连接
public class TCPClient {
	public static void main(String[] args) throws Exception{
		//1.创建Socket，传入要发送的Server端的ip地址和端口号
		Socket socket=new Socket("127.0.0.1",6666);
		//2.调用Socket.getOutputStream写入服务器端
		OutputStream os=socket.getOutputStream();
		
		DataOutputStream ds=new DataOutputStream(os);
		ds.writeUTF("hello world");
		ds.flush();
		ds.close();
		os.close();
		
	}
}
