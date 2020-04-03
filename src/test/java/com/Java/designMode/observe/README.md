#观察者模式
*   没有新的技术，只是简单的继承/实现
*   Observable 使用 Vector<Observer> obs保证线程安全
*   changed 加锁， notify加锁， 保证线程安全
*   notify方法中有一个本地变量复制的操作，主要是为了保证正确的情况下提高多线程效率。