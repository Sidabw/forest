package com.duotai;

public class templateDemo {			//template 模板
	public static void main(String[] args)
	{
		SubTime S=new SubTime();
		S.getTime();
		
	}

}
abstract class Gettime
{
	public final void getTime()
	{
		long start=System.currentTimeMillis();
		timeRun();									//abstract类不能实例化。其非abstract方法（getTime）可由其子类直接调用。
		long end=System.currentTimeMillis();
		System.out.println("时间差："+(end-start));
	}
	public abstract void timeRun();
}
class SubTime extends Gettime
{

	public void timeRun()
	{
		for(int x=1000;x<4000;x++)
		{
			System.out.println(x);
		}
	}
	
}
