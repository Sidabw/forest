package com.threaddemo;

public class ThreadDemo {
	public static void main(String[] args)
	{
		Demo d1=new Demo("one");
		Demo d2=new Demo("two");
		d1.start();	
		d2.start();//�����̣߳�����run������
		for(int y=0;y<60;y++)
			System.out.println("y......"+y);
	}

}
class Demo extends Thread
{
//	private String name;
	Demo(String name)
	{
		super(name);
	//	this.name=name;
	}
	
	public void run()
	{
		for(int x=0;x<60;x++)
			/*Thread.currentThear()��ȡ��ǰ��������ã�
			 * getName() :��ȡ�߳�����
			 * �����߳����ƣ�setName���߹��캯����
			 * */
			System.out.println(Thread.currentThread()+this.getName());
		//	System.out.println(this.getName()+"x....."+x);//���õķ����������в�����ʱ��this=super��
	}
}
