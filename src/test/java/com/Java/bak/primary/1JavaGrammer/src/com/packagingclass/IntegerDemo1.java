package com.packagingclass;

/*JDK 1.5������
 * Integer x=123;  		// 123=new Integer��123��
 * 
 * */
public class IntegerDemo1 {
	public static void main(String[] args)
	{
		Integer x=2;	//�Զ�װ�� // new Integer(4)
		x=x+1;			//�Զ�����  x.intvalue(),�����int��������1�������㣬 �ڽ����Զ�װ�� ��
		Integer a=128;
		Integer b=128;
		System.out.println(a==b);
		System.out.println(a.equals(b));//equlas��Object o�� �Ƚϴ˶�����ָ�����󡣵��ҽ���������Ϊ null��������һ����ö��������ͬ int ֵ�� Integer ����ʱ�����Ϊ true�� 
		Integer m=127;
		Integer n=127;
		System.out.println(m==n);		//true  ��Ϊ m nָ������ͬ���󣬴�-128~127����ֵ�洢��Integer��������IntegerCatch)���δ����Integer���󡣵������new Integer("...")��ͬ��
		method();						//��Ϊ��ֵ��byte��Χ��ʱ�����������ԣ��������ֵ�Ѿ����ڣ����������ڴ��п����¿ռ䡣
	}
	public static void method()
	{
		Integer x=new Integer("123");
		Integer y=new Integer(123);
		System.out.println(x==y);					// false   �����Ѿ���������δ�ڻ����������������
		System.out.println(x.equals(y));  			//true    �Ƚ���ֵ
	}

}
