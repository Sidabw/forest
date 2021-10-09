package com.Java.nio;

import org.junit.Test;

/**
 * @author shaogz
 */
public class NIODemo2 {

    @Test
    public void test1() {
        //以下：buffer的一些概念、方法

        //capacity
        //当前buffer的大小

        //position
        //写的时候，表示写到哪了
        //读的时候，表示从哪里开始读的。
        //最大是capacity - 1

        //limit
        //写的时候，等同于capacity
        //读的时候，最多能读到多少数据。换句话说，flip写切到读后，limit就会变成写模式下的position值，position则会成0


        //向buffer中写数据
        //从channel写到buffer： int bytesRead = inChannel.read(buf);
        //调用Buffer的put方法： buf.put(127);

        //从buffer中读数据
        //buffer读到channel中： inChannel.write(buf);
        //调用Buffer的get方法: byte aByte = buf.get();

        //buffer.rewind(); 倒回，及把position设置为0，然后重新读

        //清空（clear方法）：position设置为0，limit设置为capacity
        //压缩（compact方法）：所有未读元素copy到position0位置，position设置为最后1个未读元素的后面，limit设置为capacity

        //mark & reset
        //mark标记当前position，reset的时候再回到这个position

        //equals
        //buffer类型相同 & buffer剩余的byte、char等个数、数值相同 则两个buffer eq true

        //compareTo
        //比较的是两个buffer的剩余元素，即position到limit的元素
        //第一个不想等的元素小于另外1个buffer中对应的元素时，返回-1
        //所有元素都想等，但第一个buffer先耗尽时，返回-1

    }

}
