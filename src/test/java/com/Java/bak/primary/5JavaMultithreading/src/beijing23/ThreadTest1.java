package beijing23;

/*
 * Sychronized
 * 
 * 		1.��Ա��
 * 			1..��������ʱʹ��(������̳�,���ξ�̬����ʱ���������������ж���),���ڷ�Χ������(public��)֮��,������������(void��)֮ǰ����ס����Sychronized���ڵķ���public synchronized void synMethod() {}
 * 				1.1	����������һ��д�������ǽ�����������ŵ�������:bject obj =new Object();Sychronized(obj){}	����������� ����̻߳����ԶԴ˶�����г��˷��������������
 * 		2.������
 * 			1.synchronized (this) {}����߳��ڸ������ж����ϵ��κβ��������ܽ���,���˾�̬�����;�̬��������Ϊ��̬�����;�̬�����������϶������ڶ�����
 * 			3.synchronized��������������,��ʱ,�̻߳�õ��Ƕ�����	Sychronized(Single.class)����߳̽���,���߳��ڸ��������в������ܽ���,������̬�����;�̬����
 * 
 * 
 * */
public class ThreadTest1 {
	public static void main(String[] args) {
		Runner runner=new Runner();
		Thread t1=new Thread(runner);
		t1.start();
		for(int x=0;x<100;x++)	//t1 �߳���main�߳�ͬʱ���У��������Thread.sleep(100)�Ļ����ѿ��������߳��ڽ�������
		{
			try{Thread.sleep(100);}catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread()+"x="+x);
		}
	}
}
class Runner implements Runnable
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
		{
			try{Thread.sleep(100);}catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread()+"i="+i);
		}
	}
	
}
