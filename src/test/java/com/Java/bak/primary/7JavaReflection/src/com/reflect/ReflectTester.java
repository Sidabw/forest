package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/*
 * ����Class��������ַ�ʽ��1.ͨ��Class��ľ�̬������Class.forname("java.lang.String")
 * 					 2.ͨ����ǰ���.class������ InvokeTester.class;
 * 					 3.ͨ����ǰ�۶����.getClass������obj.getClass();
 * */
public class ReflectTester {
	public  Object copy(Object obj) throws Exception
	{
		Class<?> classType=obj.getClass();
		//����Ҫͨ���������Ĺ��췽����������ʱ������ʹ��Constructor�����췽��������public��
 		Constructor<?> constructor = classType.getConstructor(new Class[]{String.class,int.class});
		Object obj2=constructor.newInstance(new Object[]{"Brew",3});
		System.out.println(obj2);
		System.out.println("**********************************************************");
		
		//���ж��󿽱����˶����ڳ�Ա����---->�¶���
		Object objCopy=classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
		
		Field[] fields=classType.getDeclaredFields();
		for(Field field:fields)
		{
			String name=field.getName();
			String getMethodName="get"+name.substring(0, 1).toUpperCase()+name.substring(1);
			String setMethodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
			
			Method getMethod=classType.getMethod(getMethodName, new Class[]{});
			//field.getType()���ص�ǰfield����Ա��������class����
			Method setMethod=classType.getMethod(setMethodName, new Class[]{field.getType()});
			//int ���͵�class������int  �������������Ͳ�ͬ
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
