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
		System.out.println("main�߳�������");
		md.shutdown();
		System.out.println("MyThread�߳��Ѿ�����");
	//	md.interrupt();//�ж�md�̣߳�sleep�������жϣ��׳����쳣��catch����
		//md.stop();---->�ѹ�ʱ����������
	}
	public static void useOfDate()			//new Date():��ȡ��ǰʱ��
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
