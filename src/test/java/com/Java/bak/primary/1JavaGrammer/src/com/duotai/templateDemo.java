package com.duotai;

public class templateDemo {			//template ģ��
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
		timeRun();									//abstract�಻��ʵ���������abstract������getTime������������ֱ�ӵ��á�
		long end=System.currentTimeMillis();
		System.out.println("ʱ��"+(end-start));
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
