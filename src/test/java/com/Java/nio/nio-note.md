# nio-note

> 为什么要学nio？
>
> 1.io是阻塞的，nio则不是
>
> 2.io时面向流的，nio是面向buffer的。这也就意味着nio可以向前、向后读，但io不可以，除非你自己去实现buffer cache
>
> 3.nio有selector。1个selector可以管理多个channel，这样就不会说1个线程io阻塞了，那这个线程就阻塞了，1个channel在读写，另外1个channel该干嘛干嘛。
>
> 重要的‼️：jdk的io底层也已经使用nio重新实现，所以不用考虑nio效率高那所有的io代码是否要重构？

## Channel

* 文件IO：FileChannel
  * 读写文件
* UDP：DatagramChannel
  * 通过UDP读写网络中的数据
* TCP：SocketChannel
  * 通过TCP读写网络中的数据
* 网络IO：ServerSockerChannel
  * 监听TCP链接。类似web服务器，对每一个进来的链接建立1个SockertChannel，而不是1个线程。

## Buffer

> 缓冲区本质上是一块可以读/写数据的内存。这块内存被封装为NIO Buffer对象，并提供了1组方法方便访问该块内存。
>
> 以下涵盖了能够通过IO发送的所有基础数据类型。WHAT❓❓❓❓

* ByteBuffer
* CharBuffer
* DoubleBuffer
* FloatBuffer
* IntBuffer
* LongBuffer
* ShortBuffer

![Screen Shot 2021-09-17 at 2.11.34 PM](/Users/feiyi/Library/Application Support/typora-user-images/Screen Shot 2021-09-17 at 2.11.34 PM.png)



## Selector

Selector允许单线程处理多个Channel。像聊天服务器这种每个链接流量都很低的，就可以1个线程对应1个selector对应多个channel（链接）去处理，不用像io那样1个线程1个连接。

![Screen Shot 2021-09-17 at 2.12.05 PM](/Users/feiyi/Library/Application Support/typora-user-images/Screen Shot 2021-09-17 at 2.12.05 PM.png)

