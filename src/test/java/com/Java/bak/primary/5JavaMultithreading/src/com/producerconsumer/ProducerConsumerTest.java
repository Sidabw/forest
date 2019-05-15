package com.producerconsumer;
/*
 * PS���ڶ��߳��е���wait()����ʱ���ͷ�synchronized����--->��Demo������ж��Producer�Ϳ��ܵ���set�����ȴ��̳߳����ж���߳��ڵȴ���������һ�Ρ����Σ�����flag�жϣ������ظ��������Ρ�
 * 		���̳߳����ж��wait�߳�ʱ��notifyֻ�ܻ�����������̡߳�
 * 
 * ����������������ģ�ͣ� �����߲��������ݴ浽�����У������ߴ���������ȡ����
 * 
 * �򻯰�������������ģ�ͣ�����һ������һ��			
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
	private boolean flag;	//��֤ set������get����һ��ֻ�ܽ���1����һ�������У�һ����wait()��
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
		System.out.println(Thread.currentThread().getName()+".....������......"+this.name);
		flag=true;
		this.notifyAll();
	}
	//����synchronized����Ϊ�˱�֤get����һ��ֻ�ܽ�1���߳�
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
		System.out.println(Thread.currentThread().getName()+"........������......"+this.name);
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
			r.set("��ͷ");
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
















