package com.Java.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**
 * @author shaogz
 */
public class NIODemo1 {

    @Test
    public void test1() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("forest-list.txt", "rw");
        FileChannel channel = aFile.getChannel();

        //分配1个48字节的buffer
        ByteBuffer buf = ByteBuffer.allocate(48);

        //把流从channel写入到buffer中
        int bytesRead = channel.read(buf);
        ArrayList<Byte> bytes = new ArrayList<>();
        while (bytesRead != -1) {
            System.out.println("Read: " + bytesRead);
            //将buffer模式从写改到读
            buf.flip();

            while (buf.hasRemaining()) {
                bytes.add(buf.get());
                // System.out.println((char) buf.get());
            }
            //清空buf里的内容，准备下次写入
            buf.clear();
            bytesRead = channel.read(buf);
        }
        //会一同关闭与其关联的channel
        aFile.close();

        //以下只是测试下读到的内容
        byte[] b2 = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i ++) {
            b2[i] = bytes.get(i);
        }
        String s = new String(b2);
        System.out.println(s);
    }
}
