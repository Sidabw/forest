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
 * 		���������ǰ�Ķ���Ƕ��ѭ��
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
		int b=a;	//	------>final���εı����������ÿɱ䣬���õĶ����ܱ�
		
Question 3:
		==����equals������
		==���жϵ��ǵ�ַ��Object�е�equals�ײ�Ҳ��==�������䲻ͬ�������Բ�ͬ�ķ�ʽ��д��equals������
		���ڰ˴�����������ͣ�ֻ����==�����Ƚϡ�
		���ڱȽ϶������û������equals��������ȽϽ��ͬ==һ�������ǱȽ϶������ڴ��еĵ�ַ
		�ַ�������أ����������е�ʱ��ᴴ��һ���ַ�������ص�ʹ�� s2 = "Monday" �����ı���Ǵ����ַ�����ʱ��
		�������Ȼ������String�������Ѱ����ֵͬ�Ķ������Ը�д��equals������������ͬ������true
		String string3=new String("wangma");
		String string2=new String("wangma");
		System.out.println(string2==string3);//---------->false   �������� ������ַ
		String string4="wangma";
		String string5="wangma";
		System.out.println(string4==string5);//----------->true   
		System.out.println(string3==string4);//----------->false  ��������  ������ַ
		System.out.println(string3.equals(string4));//----------->true String ��д��Object��equals������������ͬ������true
		
Question4:
		��̬������ʵ������������
		��̬������������ԣ�ʵ�������Ƕ�������ԡ�
class Question4��
		public static void main(String[] args) {
			Person.method();
		}
}
class Person 
{
	public static void method()
	{
		System.out.println("I'm static !");		//ֻ���ӡһ��
	}
}

Question5:
		Integer��int������
		Integer��int�İ�װ�࣬Integer���࣬int�ǻ����������͡���һ�������Ĳ����б���������յ���һ�����󵫷Ž�ȥ����int���ᷢ���Զ�װ��
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
��Ӧ�����Ȩ�ޣ�	��ͬ��	���ࣨ��ͬ����	ͬһ����		ͬһ����

Question 7��
	overload�����أ���override(��д)������
	overloadֻ�뷵��ֵ�����й�

Question 8:
	interface �ǽӿڣ���abstract class��һ����������� ����ʵ�ֽӿڻ��߳����࣬����ȫ����д��abstract��������Ȼ���໹��һ��abstract�ࡣ

Question 9:
	String �಻�ɱ��̳С�-----API----->public final class String{}
	
Question 10:
	��һ�������ͳ����Ĺ�ϵ��StringBuffer��������ݿ����޸ģ���String����һ��������Ͳ����Ա��޸ģ����¸�ֵ��ʵ����������
	StringBuffer stringBuffer=new StringBuffer();����һ�����в����ַ����ַ�������������ʼ����Ϊ 16 ���ַ���
*		
 * */
