package synchronizedDemo;
/*
����ʽ��
����ʽ���ڰ�ȫ�����������߳�ͬʱ���ʵ��ø����ǻ���ֶ������Ŀ��ܣ���Ҫ����ؼ���synchronized(��֤ͬʱ��,���Ǽ���˹ؼ��ֻ�ʹ������ñ���

 * 	1.��Ա����ĳһ�߳̽�����֮�������̱߳���ȴ����߳�ִ�������ڵĳ�����ܼ������������ڵķ���
 * 			<1>Synchronized �ڷ�������������public ֮��void֮ǰ�� ���磺public Synchronized void method(){}
 * 			<2>Synchronized���� ��ĳһ������ϣ���������Խ���ı���
 * 
 * 	2.��������ĳһ�߳̽�����֮�󣬾ͻ���˴˶������������̶߳Դ˶�����κβ�������������
 * 			<1>Synchronized(this){}  �ͻ���˴˶������������̶߳Դ˶�����κβ�������������
 * 				
 * 			<2>Synchronized(Single.class){}�ͻ���˴˶������������̶߳Դ˶�����κβ�������������
 * 
 * 			<3>Object obj=new Object(); Sychronized(obj) ����������������̻߳����ԶԴ˶��������������
 * 
*
*/

public class SingleLanSynchronized {
	public static void main(String[] args)
	{
		Single s=Single.getInstance();
		s.show();
	}
}
class Single
{
	private static Single s= null;
	private Single(){}
	public static Single getInstance()
	{
		if(s==null)
		{
			synchronized(Single.class)
			{
				if(s==null)
					s=new Single();
			}
		}
		return s;
	}
	public void show()
	{
		System.out.println("dddddd");
	}
}
/* ��ʽ//��һ���ؾʹ������� 
* 
*  ����Ҫ��������Ķ������ڴ��б�֤Ψһʱ������
* ��α�֤�������ڴ���Ψһ��
* 1.�ѹ��췽��˽�л�
* 2.�ڳ�Աλ���Լ�����һ��private static ����
* 3.�ṩһ�������ķ���������
*/
class SingleE
{
	private static SingleE s=new SingleE();
	private SingleE(){}
	public static SingleE getInstance()
	{
		return s;
	}
	public void show()
	{
		System.out.println("llllllllllllllllllll");
	}
	
}
