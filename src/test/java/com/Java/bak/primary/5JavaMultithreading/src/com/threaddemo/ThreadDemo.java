package com.threaddemo;

public class ThreadDemo {
	public static void main(String[] args)
	{
		Demo d1=new Demo("one");
		Demo d2=new Demo("two");
		d1.start();	
		d2.start();//启用线程，调用run方法。
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
			/*Thread.currentThear()获取当前对象的引用，
			 * getName() :获取线程名称
			 * 设置线程名称：setName或者构造函数。
			 * */
			System.out.println(Thread.currentThread()+this.getName());
		//	System.out.println(this.getName()+"x....."+x);//调用的方法在子类中不存在时，this=super。
	}
}
