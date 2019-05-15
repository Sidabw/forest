package com.generic;
/**
 * 泛型继承。
 * */
public class GenericDemo4 {
	public static void main(String[] args)
	{
//		InterImp2 i=new InterImp2();		//方法一
		InterImpl<Integer> i=new InterImpl<Integer>();
//		i.show("hahhaa");					
		i.show(666666);			//方法二
	}

}
interface Inter<T>
{
	void show(T t);
}
class InterImpl<T> implements Inter<T>
{
	public void show(T t)
	{
		System.out.println(t);
	}
}
class InterImp2 implements Inter<String>		//方法一
{
	public void show(String s)
	{
		System.out.println(s);
	}
}