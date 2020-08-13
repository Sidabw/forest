package synchronizedDemo;
/*
懒汉式：
懒汉式存在安全隐患，当多线程同时访问调用该类是会出现多个对象的可能，需要加入关键字synchronized(保证同时）,但是加入此关键字会使程序调用变慢

 * 	1.成员锁：某一线程进入锁之后，其他线程必须等待此线程执行完锁内的程序才能继续调用锁所在的方法
 * 			<1>Synchronized 在方法上声明，在public 之后，void之前， 比如：public Synchronized void method(){}
 * 			<2>Synchronized（） 对某一代码块上，括号里可以进入的变量
 * 
 * 	2.对象锁：某一线程进入锁之后，就获得了此对象锁，其他线程对此对象的任何操作都不被允许。
 * 			<1>Synchronized(this){}  就获得了此对象锁，其他线程对此对象的任何操作都不被允许。
 * 				
 * 			<2>Synchronized(Single.class){}就获得了此对象锁，其他线程对此对象的任何操作都不被允许。
 * 
 * 			<3>Object obj=new Object(); Sychronized(obj) 虚拟对象锁，其他线程还可以对此对象进行其他操作
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
/* 恶汉式//类一加载就创建对象 
* 
*  当需要将该事物的对象在内存中保证唯一时！！！
* 如何保证对象在内存中唯一：
* 1.把构造方法私有化
* 2.在成员位置自己创建一个private static 对象
* 3.提供一个公共的方法来访问
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
