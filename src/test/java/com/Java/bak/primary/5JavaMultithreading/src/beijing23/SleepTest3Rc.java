package beijing23;

import java.util.Date;

public class SleepTest3 {
	public static void main(String[] args) {
		MyThread md=new MyThread();
		md.start();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("main线程在运行");
		md.shutdown();
		System.out.println("MyThread线程已经结束");
	//	md.interrupt();//中断md线程，sleep方法被中断，抛出的异常被catch处理，
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
