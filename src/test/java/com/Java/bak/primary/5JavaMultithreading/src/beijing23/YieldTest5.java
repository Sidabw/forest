package beijing23;

/*
 * yieldʧЧ������ͣ�
 * yield����jdk�������ݶ���ǰ�̲߳�ִ�������̡߳����仰˵��cpuִ�е�yield����ʱ���л��������̵߳�ʱ��Ƭ�ϣ������
 * ǡ�������̵߳�ʱ��Ƭ������ִ��һ�����룬�Ǿ�����˵�ǰ�߳�δ��ͣ�����Ǽ���ִ���˵ļ���
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
					yield();	//��ͣ��ǰ����ִ�е��߳�
			System.out.println(getName()+": "+i);
		}
	}
}
