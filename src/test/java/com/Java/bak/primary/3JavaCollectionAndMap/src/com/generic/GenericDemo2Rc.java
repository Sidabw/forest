package com.generic;
/*
 * 什么时候定义泛型类？
 * ↓	↓	↓	↓
 * 当类中的引用数据类型不确定时，通过定义泛型来完成扩展。
 * 之前的版本没有泛型类时往往都是通过接受Object来解决.
 * */
public class GenericDemo2 {
	public static void main(String[] args)
	{
		//创建泛型类对象，确认使用Worker。 这时QQ --->Worker
		 Tool<Worker> t=new Tool<Worker>();
		 //这时如果传 new Student()则会报错。因为上一步已经明确了泛型类使用哪一个类。
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
//泛型类,
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