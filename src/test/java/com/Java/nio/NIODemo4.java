package com.Java.nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author shaogz
 */
public class NIODemo4 {


    @Test
    public void test() throws IOException {
        //使用NIO 完成copy
        //即把1个Channel的数据传输到另外1个Channel，前提是其中1个Channel必须是FileChannel

        RandomAccessFile fromFile = new RandomAccessFile("nio-transfer/from.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("nio-transfer/to.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0L;
        //类似FileInputStream的available方法，字面意思，剩余字节
        //该channel实例所关联的文件大小
        long count = fromChannel.size();

        //也可以这么写： fromChannel.transferTo(position, count, toChannel);
        toChannel.transferFrom(fromChannel, position, count);

        toChannel.close();
        fromChannel.close();

        //注意：SocketChannel可能不会把请求的所有数据（count）传输给FileChannel, 其只会传输此刻准备好的，可能不足count
    }
}
