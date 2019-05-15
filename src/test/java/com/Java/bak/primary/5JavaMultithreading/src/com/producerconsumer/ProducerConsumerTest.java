package com.producerconsumer;
/*
 * PS：在多线程中调用wait()方法时会释放synchronized锁。--->此Demo中如果有多个Producer就可能导致set方法等待线程池中有多个线程在等待，当唤醒一次、二次，不再flag判断，导致重复生产两次。
 * 		当线程池中有多个wait线程时，notify只能唤醒随机单个线程。
 * 
 * 正常生产者消费者模型： 生产者产生的数据存到容器中，消费者从容器中提取数据
 * 
 * 简化版生产者消费者模型：生产一次消费一次			
 * 
 * */
public class ProducerConsumerTest {
	public static void main(String[] args) {
		Resourse r =new Resourse();
		Producer p1=new Producer(r);
		Consumer c1=new Consumer(r);
		Producer p2=new Producer(r);
		Consumer c2=new Consumer(r);
		Thread t1 =new Thread(p1);
		Thread t2=new Thread(c1);
		Thread t3 =new Thread(p2);
		Thread t4=new Thread(c2);
		t1.start();
		t2.start();
		
	}
}
class Resourse
{
	private String name;
	private int count;
	private boolean flag;	//保证 set方法与get方法一次只能进行1个，一个在运行，一个在wait()。
	public synchronized void set(String name)
	{
		
		while(this.flag)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		this.name=name+count;
		count++;
		System.out.println(Thread.currentThread().getName()+".....生产者......"+this.name);
		flag=true;
		this.notifyAll();
	}
	//加上synchronized锁是为了保证get方法一次只能进1个线程
	public synchronized void get()
	{
		while(!this.flag)
		{
			try {
				this.wait();
				
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println(Thread.currentThread().getName()+"........消费者......"+this.name);
		flag=false;
		this.notifyAll();
	}
}
class Producer implements Runnable
{
	private Resourse r;
	 public Producer(Resourse r) {
		// TODO Auto-generated constructor stub
		 this.r=r;
	 }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			r.set("馒头");
		}
	}
}
class Consumer implements Runnable
{
	private Resourse r;
	 public Consumer(Resourse r) {
		// TODO Auto-generated constructor stub
		 this.r=r;
	 }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			r.get();
		}
	}
}
















