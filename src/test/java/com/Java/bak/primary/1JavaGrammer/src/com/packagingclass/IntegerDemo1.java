package com.packagingclass;

/*JDK 1.5新特性
 * Integer x=123;  		// 123=new Integer（123）
 * 
 * */
public class IntegerDemo1 {
	public static void main(String[] args)
	{
		Integer x=2;	//自动装箱 // new Integer(4)
		x=x+1;			//自动拆箱  x.intvalue(),变成了int类型再与1进行运算， 在进行自动装箱 。
		Integer a=128;
		Integer b=128;
		System.out.println(a==b);
		System.out.println(a.equals(b));//equlas（Object o） 比较此对象与指定对象。当且仅当参数不为 null，并且是一个与该对象包含相同 int 值的 Integer 对象时，结果为 true。 
		Integer m=127;
		Integer n=127;
		System.out.println(m==n);		//true  因为 m n指向了相同对象，从-128~127的数值存储在Integer缓存区（IntegerCatch)里，并未创建Integer对象。但如果是new Integer("...")则不同。
		method();						//因为数值在byte范围内时，对于新特性，如果该数值已经存在，不会再在内存中开辟新空间。
	}
	public static void method()
	{
		Integer x=new Integer("123");
		Integer y=new Integer(123);
		System.out.println(x==y);					// false   对象已经创建，并未在缓存区里。是两个对象
		System.out.println(x.equals(y));  			//true    比较数值
	}

}
