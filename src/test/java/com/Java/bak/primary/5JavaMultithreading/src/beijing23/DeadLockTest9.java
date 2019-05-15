package beijing23;
/**
 * �������ͣ�
 * ����߳�1��ס��A��Ȼ���Զ�B���м�����ͬʱ�߳�2�Ѿ���ס��B�����ų��Զ�A���м�������ʱ�����ͷ����ˡ�
 * �߳�1��Զ�ò���B���߳�2Ҳ��Զ�ò���A������������ԶҲ����֪�����������������顣
 * Ϊ�˵õ��˴˵Ķ���A��B�������ǽ���Զ������ȥ�������������һ��������
 * */
public class DeadLockTest9  implements Runnable {
	public int flag=1;
	static Object object1=new Object();
	static Object object2=new Object();
	
	public static void main(String[] args) {
		DeadLockTest9 t1=new DeadLockTest9();
		DeadLockTest9 t2=new DeadLockTest9();
		Thread td1=new Thread(t1);
		Thread td2=new Thread(t2);
		t1.flag=1;
		t2.flag=2;
		td1.start();
		td2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(flag==1){
			System.out.println("flag="+flag);
			synchronized(object1){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName()+"����object2");
				synchronized(object2){
					System.out.println("2");
				}
		}
		}
		if(flag==2)
		{
			System.out.println("flag="+flag);
			synchronized(object2){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName()+"����object1");
				synchronized(object1){
					System.out.println("1");
				}
		}
	}
}
}
