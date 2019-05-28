package beijing23;
/*
 *setPriority:设置优先级...       优先级：MAX_PRIORITY(10)		NORM_PRIORITY(5)	MIN_PRIORITY(1)
 * */
public class SetPriorityTest6 {
	public static void main(String[] args) {
		Thread thread1=new Thread(new PriorityThread1());
		Thread thread2=new Thread(new PriorityThread2());
		thread1.setPriority(Thread.MAX_PRIORITY);	//虽然thread1的线程优先级是最高的，但是并不意味着只有此最高优先级线程执行完之后其他线程才能执行
		thread1.start();
		thread2.start();
		//System.out.println(thread1.MIN_PRIORITY);
	}
}
class PriorityThread1 implements Runnable
{
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			try {
				//Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("PriorityThread1/++++++"+i);
		}
	}
}
class PriorityThread2 implements Runnable
{
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println("PriorityThread2/....."+i);
		}
	}
}
