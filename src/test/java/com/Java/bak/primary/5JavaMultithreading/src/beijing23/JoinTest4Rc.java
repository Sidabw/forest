package beijing23;
/*
 * join：当前线程执行到 其他线程的join方法时，当前线程会等待其他线程执行完。
 * */
public class JoinTest4 {
	public static void main(String[] args) {
		MyThread2 myThread2 =new MyThread2("ZHANGSAN");
		myThread2.start();
		try {	
			myThread2.join();// main线程执行到了myThread2线程的join(),这时main线程会停止直到myThread()线程执行完。
		} catch (Exception e) {
			// TODO: handle exception
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
			// TODO: handle exception
			System.out.println("MyThread2 is interruted,");
			return;
		}
		}
	}
}
