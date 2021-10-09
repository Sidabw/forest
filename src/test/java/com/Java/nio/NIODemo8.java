package com.Java.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author shaogz
 */
public class NIODemo8 {

    @Test
    public void test() throws IOException {
        //MappedByteBuffer: 把磁盘上的文件映射到内存中，在内存中直接修改内容，磁盘上的文件内容也随之更改。

        RandomAccessFile randomAccessFile = new RandomAccessFile("nio-transfer/from.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());

        //直接修改指定索引的内容
        //索引为0的位置和索引为3的位置被修改为V了。
        mappedByteBuffer.put(0, (byte)'v');
        mappedByteBuffer.put(3, (byte)'v');

        //实际生效了。。。 IDEA有缓存？？？不信cat看看

    }
}
