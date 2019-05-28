package com.midtermtest;

public class Question1To10 {
	public static void main(String[] args) {
		
		Person.method();
	}

}
class Person 
{
	public static void method()
	{
		System.out.println("I'm Static");
	}
}

/*Question 1:
 * 		如何跳出当前的多重嵌套循环
 * 		for(int i=0;i<2;i++)
		{
			for(int a=0;a<5;a++)
			{
				System.out.println("a="+a);
				if(a==3)
					break;
			}
		}
*
*Quesion 2:
*		
*		final int a=3;
		int b=a;	//	------>final修饰的变量，其引用可变，引用的对象不能变
		
Question 3:
		==号与equals的区别？
		==号判断的是地址，Object中的equals底层也是==，但是其不同的子类以不同的方式复写了equals方法。
		对于八大基础数据类型，只能用==号做比较。
		对于比较对象，如果没有重修equals方法，其比较结果同==一样，都是比较对象在内存中的地址
		字符串缓冲池，程序在运行的时候会创建一个字符串缓冲池当使用 s2 = "Monday" 这样的表达是创建字符串的时候，
		程序首先会在这个String缓冲池中寻找相同值的对象。所以覆写的equals方法会内容相同即返回true
		String string3=new String("wangma");
		String string2=new String("wangma");
		System.out.println(string2==string3);//---------->false   两个对象 两个地址
		String string4="wangma";
		String string5="wangma";
		System.out.println(string4==string5);//----------->true   
		System.out.println(string3==string4);//----------->false  两个对象  两个地址
		System.out.println(string3.equals(string4));//----------->true String 覆写了Object的equals方法，内容相同即返回true
		
Question4:
		静态变量是实例变量的区别？
		静态变量是类的属性，实例变量是对象的属性。
class Question4：
		public static void main(String[] args) {
			Person.method();
		}
}
class Person 
{
	public static void method()
	{
		System.out.println("I'm static !");		//只会打印一次
	}
}

Question5:
		Integer与int的区别：
		Integer是int的包装类，Integer是类，int是基础数据类型。在一个方法的参数列表中如果接收的是一个对象但放进去的是int，会发生自动装箱
public class Question5 {
	public static void main(String[] args) {
		Person.method(5);
	}

}
class Person 
{
	public static void method(Integer integer)
	{
		System.out.println(integer.toString());
	}
}

Question 6:
				public	protected 		default 	private
对应的最大权限：	不同包	子类（不同包）	同一包内		同一类内

Question 7：
	overload（重载）与override(重写)的区别
	overload只与返回值类型有关

Question 8:
	interface 是接口，是abstract class的一种特殊情况。 子类实现接口或者抽象类，必须全部覆写其abstract方法，不然子类还是一个abstract类。

Question 9:
	String 类不可被继承。-----API----->public final class String{}
	
Question 10:
	是一个变量和常量的关系。StringBuffer对象的内容可以修改；而String对象一旦产生后就不可以被修改，重新赋值其实是两个对象。
	StringBuffer stringBuffer=new StringBuffer();构造一个其中不带字符的字符串缓冲区，初始容量为 16 个字符。
*		
 * */
