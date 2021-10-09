package com.Java.nio;

import org.junit.Test;

/**
 * @author shaogz
 */
public class NIODemo6 {

    @Test
    public void test(){
        //FileChannel 无法设置为非阻塞的，其总是运行在阻塞模式下

        //可以通过InputStream OutputStream RandomAccessFile 获取1个FileChannel

        //获取FileChannel的position：long pos = aChannel.position()
        //设置FileChannel的position：aChannel.position(123);


    }

}
