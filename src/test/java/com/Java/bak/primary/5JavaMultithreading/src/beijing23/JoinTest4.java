package beijing23;
/*
 * join����ǰ�߳�ִ�е� �����̵߳�join����ʱ����ǰ�̻߳�ȴ������߳�ִ���ꡣ
 * */
public class JoinTest4 {
	public static void main(String[] args) {
		MyThread2 myThread2 =new MyThread2("ZHANGSAN");
		myThread2.start();
		try {	
			myThread2.join();// main�߳�ִ�е���myThread2�̵߳�join(),��ʱmain�̻߳�ֱֹͣ��myThread()�߳�ִ���ꡣ
		} catch (Exception e) {
			// TODO: handle exception
		}
		for(int x=0;x<100;x++)
		{
			System.out.println("main......X��ֵ�ǣ�"+x);
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
			System.out.println("MyThread2....i��ֵ�ǣ�"+i);
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("MyThread2 is interruted,");
			return;
		}
		}
	}
}
