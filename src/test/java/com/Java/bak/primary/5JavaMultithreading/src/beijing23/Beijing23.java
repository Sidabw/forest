package beijing23;

import java.util.Date;

/*
 * Sychronized
 *
 * 	1.成员锁：某一线程进入锁之后，其他线程必须等待此线程执行完锁内的程序才能继续调用锁所在的方法
 * 			<1>Synchronized 在方法上声明，在public 之后，void之前， 比如：public Synchronized void method(){}
 * 			<2>Synchronized（） 对某一代码块上，括号里可以进入的变量
 *
 * 	2.对象锁：某一线程进入锁之后，就获得了此对象锁，其他线程对此对象的任何操作都不被允许。
 * 			<1>Synchronized(this){}  就获得了此对象锁，其他线程对此对象的任何操作都不被允许。
 *
 * 			<2>Synchronized(Single.class){}就获得了此对象锁，其他线程对此对象的任何操作都不被允许。
 *
 * 			<3>Object obj=new Object(); Sychronized(obj) 虚拟对象锁，其他线程还可以对此对象进行其他操作
 * */


//1
//多线程启动的两种方式之一
class ThreadTest1 {

    public static void main(String[] args) {
        Runner runner=new Runner();
        Thread t1=new Thread(runner);
        t1.start();
        for(int x=0;x<100;x++)	//t1 线程与main线程同时运行，如果不加Thread.sleep(100)的话很难看出两个线程在交叉运行
        {
            try{
                Thread.sleep(100);
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"x="+x);
        }
    }
}
class Runner implements Runnable
{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i=0;i<100;i++)
        {
            try{
                Thread.sleep(100);
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"i="+i);
        }
    }

}

//2
//多线程启动的两种方式之二  ：  继承Thread ,实现 Runnable
class ThreadTest2 {

    public static void main(String[] args) {
        MyThread0 walker =new MyThread0();
        walker.start();
        for(int x=0;x<100;x++)
        {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            System.out.println("X的值是："+x);
        }
    }
}
class MyThread0 extends Thread{

    public void run() {
        for(int i=0;i<100;i++)
        {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            System.out.println("i的值是："+i);
        }
    }

}


//3
//sleep interrupt 方法测试
class ThreadTest3 {

    public static void main(String[] args) {
        MyThread md=new MyThread();
        md.start();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("main线程在运行");
//		md.shutdown();
        System.out.println("MyThread线程已经结束");
        md.interrupt();//中断md线程，sleep方法被中断，抛出的异常被catch处理，
        //md.stop();---->已过时，不能用了
    }
    public static void useOfDate()			//new Date():获取当前时间
    {
        System.out.println("======="+new Date()+"=========");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("======="+new Date()+"=========");
    }
}
class MyThread extends Thread
{
    public boolean flag=true;

    public void run(){
        while(flag){
            System.out.println("======="+new Date()+"=========");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("I'm interrupted,help!help!!!");
                return;
            }
        }
    }
    public void shutdown(){
        flag=false;
    }
}


//4
//join：当前线程执行到 其他线程的join方法时，当前线程会等待其他线程执行完。遇到yield，不会暂停，因为其已经执行join。
class ThreadTest4 {

    public static void main(String[] args) {
        MyThread2 myThread2 =new MyThread2("NGSAN");
        myThread2.start();
        try {
            myThread2.join();// main线程执行到了myThread2线程的join(),这时main线程会停止直到myThread()线程执行完。
        } catch (Exception e) {
        }
        for(int x=0;x<100;x++)
        {
            System.out.println("main......X的值是："+x);
        }
    }
}
class MyThread2 extends Thread
{
    MyThread2(String name)
    {
        super(name);
    }
    public void run()
    {
        for(int i=0;i<100;i++){
            try {
                System.out.println("MyThread2....i的值是："+i);
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("MyThread2 is interruted,");
                return;
            }
        }
    }
}


//5
//yield方法使用
/*
 * yield失效问题解释：
 * yield方法jdk解释是暂定当前线程并执行其他线程。换句话说，cpu执行到yield方法时会切换到其他线程的时间片上，而如果
 * 恰好其他线程的时间片不足以执行一条代码，那就造成了当前线程未暂停，而是继续执行了的假象。
 * */
class ThreadTest5 {
    public static void main(String[] args) {
        MyThread3 t1=new MyThread3("ssss");
        MyThread3 t2=new MyThread3("zzzz");
        t1.start();
        t2.start();
    }
}
class MyThread3 extends Thread
{
    public MyThread3(String name) {
        // TODO Auto-generated constructor stub
        super(name);
    }
    public void run()
    {
        for(int i=0;i<100;i++)
        {
            if(i%10==0)
                yield();	//暂停当前正在执行的线程
            System.out.println(getName()+": "+i);
        }
    }
}


//6
//setPriority:设置优先级...       优先级：MAX_PRIORITY(10)		NORM_PRIORITY(5)	MIN_PRIORITY(1)
class ThreadTest6 {

    public static void main(String[] args) {
        Thread thread1=new Thread(new PriorityThread1());
        Thread thread2=new Thread(new PriorityThread2());
        thread1.setPriority(Thread.MAX_PRIORITY);	//虽然thread1的线程优先级是最高的，但是并不意味着只有此最高优先级线程执行完之后其他线程才能执行
        thread1.start();
        thread2.start();
        //System.out.println(thread1.MIN_PRIORITY);
    }
}
class PriorityThread1 implements Runnable
{
    public void run()
    {
        for(int i=0;i<100;i++)
        {
            try {
                //Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("PriorityThread1/++++++"+i);
        }
    }
}
class PriorityThread2 implements Runnable
{
    public void run()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println("PriorityThread2/....."+i);
        }
    }
}


//7
//多线程同时访问共享数据导致并发问题 -> synchronized 锁使用
class ThreadTest7 implements Runnable {
    MyThread4 timer =new MyThread4();
    public static void main(String[] args) {
        ThreadTest7 test =new ThreadTest7();
        Thread t1=new Thread(test);
        Thread t2=new Thread(test);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        timer.add(Thread.currentThread().getName());		//Thread.currentThread()	返回当前执行的线程的引用
    }
}
class MyThread4
{
    int num=0;
    public void add(String name)
    {
        while(true)
        {
            synchronized (this) {
                num++;
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                System.out.println(name+"你是第"+num+"个执行此方法的线程");
            }
        }
    }
}

//8
//死锁
/**
 * 死锁解释：
 * 如果线程1锁住了A，然后尝试对B进行加锁，同时线程2已经锁住了B，接着尝试对A进行加锁，这时死锁就发生了。
 * 线程1永远得不到B，线程2也永远得不到A，并且它们永远也不会知道发生了这样的事情。
 * 为了得到彼此的对象（A和B），它们将永远阻塞下去。这种情况就是一个死锁。
 * */
class ThreadTest8  implements Runnable {
    public int flag=1;
    static Object object1=new Object();
    static Object object2=new Object();

    public static void main(String[] args) {
        ThreadTest8 t1=new ThreadTest8();
        ThreadTest8 t2=new ThreadTest8();
        Thread td1=new Thread(t1);
        Thread td2=new Thread(t2);
        t1.flag=1;
        t2.flag=2;
        td1.start();
        td2.start();
    }

    @Override
    public void run() {
        if(flag==1){
            System.out.println("flag="+flag);
            synchronized(object1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"还差object2");
                synchronized(object2){
                    System.out.println("2");
                }
            }
        }
        if(flag==2) {
            System.out.println("flag="+flag);
            synchronized(object2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"还差object1");
                synchronized(object1){
                    System.out.println("1");
                }
            }
        }
    }
}


//9
//synchronized 方法锁
class ThreadTest9<synchronizedvoid> implements Runnable  {
    int b=1;
    public static void main(String[] args) throws InterruptedException {

        ThreadTest9 sm=new ThreadTest9<>();
        Thread t=new Thread(sm);
        t.start();
        sm.m2();
        System.out.println("b的值为："+sm.b);
    }

    @Override
    public void run() {
        try {
            m1();
            //Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void m1() throws InterruptedException{
        b=1000;
        Thread.sleep(2000);
        System.out.println("b="+b);
    }
    public void m2() throws InterruptedException{
        Thread.sleep(5000);
        b=2000;
    }
}

//10
//Object 的wait 和 notify方法使用
class ThreadTest91 {

    public static void main(String[] args) {
        Res res=new Res();
        Input in=new Input(res);
        Output out =new Output(res);
        Thread t1=new Thread(in);
        Thread t2=new Thread(out);
        t1.start();
        t2.start();
    }
}

class Res {
    String name;
    String sex;
    boolean flag=false;
}

class Input implements  Runnable {
    private Res s;
    Input(Res s)
    {
        this.s=s;
    }
    public void run() {
        int i=0;
        while(true) {
            synchronized (s) {
                if(s.flag) {
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                    }
                }
                if(i==0) {
                    s.name="罗蕾";
                    s.sex="女女女女女";
                } else{
                    s.name="ShaoGuangze";
                    s.sex="manmanmanman";
                }
                i++;
                i=i%2;
                s.flag=true;
                s.notify();
            }
        }
    }
}
class Output implements Runnable {
    private Res s;
    Output(Res s)
    {
        this.s=s;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (s){
                if(!s.flag) {
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("名字是："+s.name+"性别是："+s.sex);
                s.flag=false;
                s.notify();
            }
        }
    }

}