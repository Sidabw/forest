package com.generic;
/**
 * ���ͼ̳С�
 * */
public class GenericDemo4 {
	public static void main(String[] args)
	{
//		InterImp2 i=new InterImp2();		//����һ
		InterImpl<Integer> i=new InterImpl<Integer>();
//		i.show("hahhaa");					
		i.show(666666);			//������
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
class InterImp2 implements Inter<String>		//����һ
{
	public void show(String s)
	{
		System.out.println(s);
	}
}