package day17;
/**
 * 1.���̱߳��ȴ�����Ϊ��ִ����join���������������̻߳�ȴ�t1ִ���ꡣ
 * 2.t1��һ��ִ�У�����yield��������ͣ����Ϊ���Ѿ�ִ��join��
 * */
public class JoinDemo {
	public static void main(String[] args)throws Exception
	{
		Demo d=new Demo();
		Thread t1=new Thread(d);
		Thread t2=new Thread(d);
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);//�����߳�������ȼ���
		t1.join();//��A�߳�ִ�е�B�̵߳�.join()����ʱ��A�߳̾ͻ�ȴ�B�߳�ִ������ִ�С������̲߳���ȴ���
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
			Thread.yield();//��ǰ�߳���ͣ��ִ�������̡߳�
		}
		
	}
}
