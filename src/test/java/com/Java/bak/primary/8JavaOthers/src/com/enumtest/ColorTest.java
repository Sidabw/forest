package com.enumtest;
/*
 * enum同class interface一样属于java的关键字，其中的values方法是jvm在编译java的时候添加的静态方法，并不是Enum类的中法。
 * 
 * 使用enum定义枚举类型时，定义出来的类型实质上是继承自java.lang.Enum,每个枚举类型的成员就是一个实例（instance），public static final
 * 
 * 将枚举放置到参数列表中来，可以明确限制接受的参数。 
 * */
public class ColorTest {
	public static void main(String[] args) {
		Color myColor=Color.BLACK;
		System.out.println(myColor);
		System.out.println("******************");
		
		for(Color c:Color.values())
		{
			System.out.println(c);
		}
	}
}
