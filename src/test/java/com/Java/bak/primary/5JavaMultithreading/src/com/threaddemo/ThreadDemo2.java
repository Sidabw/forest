package com.threaddemo;

/*
 * Synchronized:
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
 * 
 * 
 * */
public class ThreadDemo2 
{
	public static void main(String[] args)
	
	{
	Ticket t =new Ticket();
	Thread t1=new Thread(t);		//虽然创建了4个线程，但是共用得是一个Ticket t
	Thread t2=new Thread(t);
	Thread t3=new Thread(t);
	Thread t4=new Thread(t);
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	}
}
class Ticket implements Runnable
{
	public int flag;
	private int tick=100;
	Object obj= new Object();
	public void run()
	{
		while(true)
		{
			
//		synchronized(obj)
//			{
//			try{Thread.sleep(100);}catch(Exception e){};
			if(tick>0)
				System.out.println(Thread.currentThread().getName()+"    "+tick--); //这里tick如果等于100，那么执行完此行代码，tick=99
//			}
		}
	}
}
