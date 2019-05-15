package com.threaddemo;

/*
 * Synchronized:
 * 
 * 	1.��Ա����ĳһ�߳̽�����֮�������̱߳���ȴ����߳�ִ�������ڵĳ�����ܼ������������ڵķ���
 * 			<1>Synchronized �ڷ�������������public ֮��void֮ǰ�� ���磺public Synchronized void method(){}
 * 			<2>Synchronized���� ��ĳһ������ϣ���������Խ���ı���
 * 
 * 	2.��������ĳһ�߳̽�����֮�󣬾ͻ���˴˶������������̶߳Դ˶�����κβ�������������
 * 			<1>Synchronized(this){}  �ͻ���˴˶������������̶߳Դ˶�����κβ�������������
 * 				
 * 			<2>Synchronized(Single.class){}�ͻ���˴˶������������̶߳Դ˶�����κβ�������������
 * 
 * 			<3>Object obj=new Object(); Sychronized(obj) ����������������̻߳����ԶԴ˶��������������
 * 
 * 
 * */
public class ThreadDemo2 
{
	public static void main(String[] args)
	
	{
	Ticket t =new Ticket();
	Thread t1=new Thread(t);		//��Ȼ������4���̣߳����ǹ��õ���һ��Ticket t
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
				System.out.println(Thread.currentThread().getName()+"    "+tick--); //����tick�������100����ôִ������д��룬tick=99
//			}
		}
	}
}
