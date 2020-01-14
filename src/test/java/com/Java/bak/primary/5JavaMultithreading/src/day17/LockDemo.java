package day17;

import java.util.concurrent.locks.*;

/*
 * Lock 和 synchronized 的区别
 * 1. synchronized是Java关键字.....
 * 2. Lock需要手动释放锁,synchronized不需要；遇到异常时，synchronized会被JVM自动释放，Lock则必须在finally中unlock
 * 3. synchronized是非公平锁，谁抢到算谁的；ReentrantLock可以指定为公平锁，谁先等待锁谁先获得锁。
 *
 * Condition:
 * @Author: feiyi
 * @Date: 2019/12/30 4:33 PM
 **/
public class LockDemo {
	public static void main(String[] args) {
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
class Resource {
	private String name;
	private int count=0;
	private boolean flag=false;
	private Lock lock=new ReentrantLock();
	private Condition condition_pro=lock.newCondition();
	private Condition condition_con=lock.newCondition();
	public void set(String name)throws InterruptedException {
		lock.lock();
		try {
			while(flag)		
			    condition_pro.await();//造成当前线程在接到信号或被中断之前一直处于等待状态。
            this.name=name+count++;
            System.out.println(Thread.currentThread().getName()+"....生产者...."+this.name);
            flag=true;
            condition_con.signal();
		} catch (Exception e) {

        } finally {
			lock.unlock();
		}
	}
	public void out()throws InterruptedException {
		lock.lock();
		try {
            while(!flag)
                condition_con.await();
            System.out.println(Thread.currentThread().getName()+".....消费者。。。。"+name);
            flag=false;
            condition_pro.signal();
		}
		finally {
			lock.unlock();
		}
	}
}
class Producer implements Runnable {
	private Resource r;
	Producer(Resource r)
	{
		this.r=r;
	}
	public void run() {
		while(true) {
			try {
				r.set("....商品....");
			}
			catch(InterruptedException e) {e.printStackTrace();}
		}
	}
}
class Consumer implements Runnable {
	private Resource r;
	Consumer(Resource r)
	{
		this.r=r;
	}
	public void run() {
		while(true) {
			try {
				r.out();
			}
			catch(InterruptedException e) {e.printStackTrace();}
		}
	}
}
