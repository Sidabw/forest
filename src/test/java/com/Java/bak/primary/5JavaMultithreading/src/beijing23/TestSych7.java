package beijing23;
/*
 * �����̷߳���ͬһ��add����
 * */
public class TestSych7 implements Runnable {
	Timer timer =new Timer();
	public static void main(String[] args) {
		TestSych7 test =new TestSych7();
		Thread t1=new Thread(test);
		Thread t2=new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		timer.add(Thread.currentThread().getName());		//Thread.currentThread()	���ص�ǰִ�е��̵߳�����
	}
}
class Timer
{
	int num=0;
	public void add(String name)
	{
		while(true)
		{
		synchronized (this) {
			num++;
			try {
				Thread.sleep(100); 
			} catch (Exception e) {
			}
			System.out.println(name+"���ǵ�"+num+"��ִ�д˷������߳�");
		}
		}
	}
}
