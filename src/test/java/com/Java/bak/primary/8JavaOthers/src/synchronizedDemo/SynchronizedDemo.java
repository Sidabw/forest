package synchronizedDemo;

public class SynchronizedDemo {
	public static void main(String[] agr)
	{
	Cus c=new Cus();
//	Cus s=new Cus();
	Thread c1=new Thread(c);
	
	Thread c2=new Thread(c);		//当变量为局部变量时，虽然只有1个对象，但是两个线程调用则有两份局部变量。但当变量在成员变量的位置上时，1个对象，2个线程，1份变量
									//这种情况下，是两个线程公用1个对象，维护了1个bank，但有两份局部变量。
	c1.start();
	c2.start();
	}
}
class bank
{
	int sum;
	public synchronized void add(int n)
	{
		sum=sum+n;
		try{Thread.sleep(10);}catch(Exception e){}
		System.out.println(Thread.currentThread().getName()+"    "+sum);
	}
}
class Cus implements Runnable
{
	//public static int x=0;
	private bank b=new bank();
	public void run()
	{
		for(int x=0;x<3;x++)
		{
			System.out.println("    "+Thread.currentThread().getName()+x);
			try {
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName()+"    "+x);
			} catch (Exception e) {
				// TODO: handle exception
			}
			b.add(100);
		}
	} 
}