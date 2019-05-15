package day17;
/**
 * 1.主线程被等待（因为其执行了join方法），所以主线程会等待t1执行完。
 * 2.t1第一次执行，遇到yield，不会暂停，因为其已经执行join。
 * */
public class JoinDemo {
	public static void main(String[] args)throws Exception
	{
		Demo d=new Demo();
		Thread t1=new Thread(d);
		Thread t2=new Thread(d);
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);//设置线程最高优先级；
		t1.join();//当A线程执行到B线程的.join()方法时，A线程就会等待B线程执行完再执行。其他线程不会等待。
		t2.start();
		for(int x=0;x<80;x++)
		{
			System.out.println(Thread.currentThread().getName()+"....."+x);
		}
		System.out.println("over");
	}
}
class Demo implements Runnable
{
	public void run()
	{
		for(int x=0;x<70;x++)
		{
			System.out.println(Thread.currentThread().getName()+"......."+x);
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			Thread.yield();//当前线程暂停，执行其他线程。
		}
		
	}
}
