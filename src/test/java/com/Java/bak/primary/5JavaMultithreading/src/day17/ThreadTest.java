package day17;

public class ThreadTest {
	public static void main(String[] args)
	{
		new Thread()
		{	
			public void run()
			{
				for(int x=0;x<60;x++)
				{
					System.out.println(Thread.currentThread().getName()+"...."+x);
				}
			}
		}.start(); //  匿名内部类
		for(int x=0;x<60;x++)
		{
			System.out.println(Thread.currentThread().getName()+"...."+x);
		}
		Runnable r=new Runnable()
		{
			public void run()
			{
				for(int x=0;x<60;x++)
				{
					System.out.println(Thread.currentThread().getName()+"...."+x);
				}				
			}
		};//  匿名内部类
		new Thread(r).start();
	}
}
