package com.exceptiontest;

public class ExceptionText2 {
	public static void main(String[] args)
	{
		Demo3 d=new Demo3();
		try
		{
			int x=d.div(4,-6);
			System.out.println(x);
		}
		catch(FushuException e)
		{
			System.out.println(e.toString());
			e.printStackTrace();//-------------------------->�������Ķ�ջ��Ϣ	
			System.out.println("����ĸ����ǣ�"+e.getvelue());
			
		}
	}
}
class FushuException extends Exception
{
	/**
	 * @author brew
	 */
	private static final long serialVersionUID = -3897914378141657781L;
	private int value;
	FushuException(String msg)
	{
		super(msg);
	}	
	FushuException(String msg,int value)
	{
		super(msg);
		this.value=value;
	}
	int getvelue()
	{
		return value;
	}
}
class Demo3
{
	int div(int a,int b)throws FushuException
	{
		if(b<0)
			throw new FushuException("���ָ���������by zero",b);
		return a/b;
	}
}
