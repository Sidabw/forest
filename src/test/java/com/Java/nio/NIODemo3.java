package com.Java.nio;

import org.junit.Test;

/**
 * @author shaogz
 */
public class NIODemo3 {

    @Test
    public void test(){
        //1个channel对应多个buffer
        //scatter分散，把1个channel的数据写到多个Buffer中去
        //gather聚集，1个channel从多个Buffer中读数据


        //scatter, 就是调用channel.read()时传1个ByteBuffer[]
        //注意就是，像多个ByteBuffer中写，也只能是1个写满了再写另外1个

        //gather，就是调用channel.write()时传1个ByteBuffer[]
        //注意就是，channel读每一个buffer中的数据时，只会读position到limit，所以gather对于动态消息的处理比较友好


    }
}
