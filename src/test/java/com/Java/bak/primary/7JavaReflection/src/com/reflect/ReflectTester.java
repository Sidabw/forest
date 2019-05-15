package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/*
 * 创建Class对象的三种方式：1.通过Class类的静态方法：Class.forname("java.lang.String")
 * 					 2.通过当前类的.class方法： InvokeTester.class;
 * 					 3.通过当前累对象的.getClass方法：obj.getClass();
 * */
public class ReflectTester {
	public  Object copy(Object obj) throws Exception
	{
		Class<?> classType=obj.getClass();
		//当需要通过带参数的构造方法创建对象时，必须使用Constructor，构造方法必须是public的
 		Constructor<?> constructor = classType.getConstructor(new Class[]{String.class,int.class});
		Object obj2=constructor.newInstance(new Object[]{"Brew",3});
		System.out.println(obj2);
		System.out.println("**********************************************************");
		
		//进行对象拷贝，此对象内成员变量---->新对象
		Object objCopy=classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
		
		Field[] fields=classType.getDeclaredFields();
		for(Field field:fields)
		{
			String name=field.getName();
			String getMethodName="get"+name.substring(0, 1).toUpperCase()+name.substring(1);
			String setMethodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
			
			Method getMethod=classType.getMethod(getMethodName, new Class[]{});
			//field.getType()返回当前field（成员变量）的class对象
			Method setMethod=classType.getMethod(setMethodName, new Class[]{field.getType()});
			//int 类型的class对象是int  与其他数据类型不同
			System.out.println(field.getType());
			
			Object value=getMethod.invoke(obj, new Object[]{});
			setMethod.invoke(objCopy, new Object[]{value});
		}
		System.out.println("**********************************************************");
		return objCopy;
		
	}
	public static void main(String[] args)throws Exception
	{
		ReflectTester t=new ReflectTester();
		Customer c=new Customer("Sida",2);
		c.setId(1L);
		Customer cu=(Customer)t.copy(c);
		System.out.println(cu.getAge()+","+cu.getName()+","+cu.getId());
	}
}
class Customer
{
	private Long id;
	private String name;
	private int age;
	public Customer(){}
	public Customer(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
