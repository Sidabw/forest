package beijing23;
/*
 *setPriority:�������ȼ�...       ���ȼ���MAX_PRIORITY(10)		NORM_PRIORITY(5)	MIN_PRIORITY(1)
 * */
public class SetPriorityTest6 {
	public static void main(String[] args) {
		Thread thread1=new Thread(new PriorityThread1());
		Thread thread2=new Thread(new PriorityThread2());
		thread1.setPriority(Thread.MAX_PRIORITY);	//��Ȼthread1���߳����ȼ�����ߵģ����ǲ�����ζ��ֻ�д�������ȼ��߳�ִ����֮�������̲߳���ִ��
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
