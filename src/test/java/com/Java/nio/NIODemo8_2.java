package com.Java.nio;

import org.junit.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author shaogz
 */
public class NIODemo8_2 {

    @Test
    public void mappedBufferReading() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("nio-transfer/from.txt");
        FileChannel channel = fileInputStream.getChannel();
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

        if (mappedByteBuffer != null) {
            CharBuffer decode = StandardCharsets.UTF_8.decode(mappedByteBuffer);
            System.out.println(decode);
        }
    }

    @Test
    public void mappedBufferWriting() throws IOException{
        CharBuffer contentToWrite = CharBuffer.wrap("hahha-a-");
        int len = contentToWrite.length();

        RandomAccessFile randomAccessFile = new RandomAccessFile("nio-transfer/m-test.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, len);
        map.put(StandardCharsets.UTF_8.encode(contentToWrite));
        channel.close();
    }
}
