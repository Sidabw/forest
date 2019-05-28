package beijing23;

/*
 * yield失效问题解释：
 * yield方法jdk解释是暂定当前线程并执行其他线程。换句话说，cpu执行到yield方法时会切换到其他线程的时间片上，而如果
 * 恰好其他线程的时间片不足以执行一条代码，那就造成了当前线程未暂停，而是继续执行了的假象。
 * 
 * */
public class YieldTest5 {
	public static void main(String[] args) {
		YieldThread t1=new YieldThread("ssss");
		YieldThread t2=new YieldThread("zzzz");
		t1.start();
		t2.start();
	}
}
class YieldThread extends Thread
{
	public YieldThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			if(i%10==0)
					yield();	//暂停当前正在执行的线程
			System.out.println(getName()+": "+i);
		}
	}
}
