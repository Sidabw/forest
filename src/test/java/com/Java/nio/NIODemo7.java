package com.Java.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author shaogz
 */
public class NIODemo7 {

    @Test
    public void testSocketClient() throws IOException{
        //nio.SocketChannel是1个连接到TCP网络套接字的通道
        //可以手动创建SocketChannel，另外ServerSocketChannel.accept也会返回1个SocketChannel

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));

        //socketChannel.read() 一直读到-1就表示链接关闭了
        //socketChannel.write()

        //设置为non-blocking mode后，就可以以非阻塞的方式调用connect、read、write了
    }

    @Test
    public void testSocketServer() throws IOException {
        //nio.ServerSocketChannel同io.ServerSocket一样，都是可以监听新进来的TCP链接。


        //创建
        ServerSocketChannel socketServer = ServerSocketChannel.open();
        //绑定端口
        socketServer.socket().bind(new InetSocketAddress(9999));
        //指定非阻塞模式，此时accept会立即返回，需手动判断返回的是否为null。
        //默认是阻塞模式，此时accept会阻塞。
        socketServer.configureBlocking(false);

        while (true) {
            SocketChannel socketClient = socketServer.accept();
            if (socketClient != null) {
                //接收到客户端的链接了，做点什么把...  比如，先把请求数据读出来？
            }
        }

        //关闭
        // socketServer.close();

    }

}
