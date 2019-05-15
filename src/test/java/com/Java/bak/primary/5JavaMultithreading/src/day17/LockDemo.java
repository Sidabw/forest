package day17;

import java.util.concurrent.locks.*;


public class LockDemo {
	public static void main(String[] args)
	{
		Resource r=new Resource();
		Producer p1=new Producer(r);
		Producer p2=new Producer(r);
		Consumer c1=new Consumer(r);
		Consumer c2=new Consumer(r);
		Thread t1=new Thread(p1);
		Thread t2=new Thread(p2);
		Thread t3=new Thread(c1);
		Thread t4=new Thread(c2);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
class Resource
{
	private String name;
	private int count=0;
	private boolean flag=false;
	private Lock lock=new ReentrantLock();
	private Condition condition_pro=lock.newCondition();
	private Condition condition_con=lock.newCondition();
	public void set(String name)throws InterruptedException
	{
		lock.lock();
		try
		{
			while(flag)		
			condition_pro.await();//��ɵ�ǰ�߳��ڽӵ��źŻ��ж�֮ǰһֱ���ڵȴ�״̬��
		this.name=name+count++;
		System.out.println(Thread.currentThread().getName()+"....������...."+this.name);
		flag=true;
		condition_con.signal();
		}
		finally
		{
			lock.unlock();
		}
	}
	public void out()throws InterruptedException
	{
		lock.lock();
		try
		{
		while(!flag)
			condition_con.await();
		System.out.println(Thread.currentThread().getName()+".....�����ߡ�������"+name);
		flag=false;
		condition_pro.signal();
		}
		finally
		{
			lock.unlock();
		}
	}
}
class Producer implements Runnable
{
	private Resource r;
	Producer(Resource r)
	{
		this.r=r;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				r.set("....��Ʒ....");
			}
			catch(InterruptedException e)
			{}
		}
	}
}
class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r=r;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				r.out();
			}
			catch(InterruptedException e)
			{}
		}
	}
}
