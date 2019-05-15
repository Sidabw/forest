package com.threaddemo;

public class ThreadTest {
	public static void main(String[] args)
	{
		Demo1 d1=new Demo1();
		Demo1 d2=new Demo1();
		Demo1 d3=new Demo1();
		Demo1 d4=new Demo1();
		d1.start();
		d2.start();
		d3.start();
		d4.start();
	}

}
class Demo1 extends Thread
{
	
	private static int tick=1000;//��������static����ʱ����Ȼ������4��Demo���󣬵���ֻ��һ��tick����
	public void run()
	{
//		System.out.println(tick);
	while(true)
	{
		
		if(tick>0)
			System.out.println(Thread.currentThread().getName()+"        "+tick--);
		else
			break;
	}
	}
}
