package com.generic;
/**
 * 对于自定义泛型类，如果方法上没有自定义泛型的话，那么该类就只有1个泛型。
 * 故而，方法上再额外定义泛型，提高程序扩展性。
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
	public <S>void print(S s)		//将泛型定义在方法上，提高程序扩展性
	{
		System.out.println(s);
	}
	public static<W> void method(W w)		//注意：静态方法不能访问类上定义的泛型
	{
		System.out.println(w);
	}
	//错误示例：Cannot make a static reference to the non-static type L
	/*public static void method(L l)		//注意：静态方法不能访问类上定义的泛型
	{
		System.out.println(l);
	}*/
}
