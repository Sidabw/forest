package synchronizedDemo;

public class SynchronizedDemo {
	public static void main(String[] agr)
	{
	Cus c=new Cus();
//	Cus s=new Cus();
	Thread c1=new Thread(c);
	
	Thread c2=new Thread(c);		//������Ϊ�ֲ�����ʱ����Ȼֻ��1�����󣬵��������̵߳����������ݾֲ����������������ڳ�Ա������λ����ʱ��1������2���̣߳�1�ݱ���
									//��������£��������̹߳���1������ά����1��bank���������ݾֲ�������
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