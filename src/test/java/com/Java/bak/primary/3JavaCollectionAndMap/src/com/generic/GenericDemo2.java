package com.generic;
/*
 * ʲôʱ���巺���ࣿ
 * ��	��	��	��
 * �����е������������Ͳ�ȷ��ʱ��ͨ�����巺���������չ��
 * ֮ǰ�İ汾û�з�����ʱ��������ͨ������Object�����.
 * */
public class GenericDemo2 {
	public static void main(String[] args)
	{
		//�������������ȷ��ʹ��Worker�� ��ʱQQ --->Worker
		 Tool<Worker> t=new Tool<Worker>();
		 //��ʱ����� new Student()��ᱨ����Ϊ��һ���Ѿ���ȷ�˷�����ʹ����һ���ࡣ
		 t.setQQ(new Worker());
		 Worker w=t.getQQ();
		 t.print("haha");
		 w.printWorker();
	}

}
class Student
{
	
}
class Worker
{
	public void printWorker()
	{
		System.out.println(this.toString());
	}
}
//������,
class Tool<QQ>
{
	private QQ q;
	public void setQQ(QQ q)
	{
		this.q=q;
	}
	public QQ getQQ()
	{
		return q;
	}
	public void print(String s)
	{
		System.out.println(s);
	}
}