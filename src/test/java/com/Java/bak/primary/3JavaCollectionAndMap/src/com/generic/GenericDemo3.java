package com.generic;
/**
 * �����Զ��巺���࣬���������û���Զ��巺�͵Ļ�����ô�����ֻ��1�����͡�
 * �ʶ����������ٶ��ⶨ�巺�ͣ���߳�����չ�ԡ�
 * */
public class GenericDemo3 {
	public static void main(String[] args)
	{
		Demo<String> d=new Demo<String>();
		d.show("hahhaha");
		d.print(6);
		Demo.method(new Integer(8));
	}
}
class Demo<L>
{
//	private L l;
	
	public void show(L l)
	{
		System.out.println(l);
	}
	public <S>void print(S s)		//�����Ͷ����ڷ����ϣ���߳�����չ��
	{
		System.out.println(s);
	}
	public static<W> void method(W w)		//ע�⣺��̬�������ܷ������϶���ķ���
	{
		System.out.println(w);
	}
	//����ʾ����Cannot make a static reference to the non-static type L
	/*public static void method(L l)		//ע�⣺��̬�������ܷ������϶���ķ���
	{
		System.out.println(l);
	}*/
}
