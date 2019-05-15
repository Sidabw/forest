package com.exceptiontest;
/*
 * 1.java��final finally finalize������
 * 		final�����ε����Բ��ɸ��ģ����εķ������ɱ����ิд�����ε��಻�ɱ��̳�
 * 		finally���쳣���������һ��ִ�еĴ��롣ʹ�� finally ����ά��������ڲ�״̬��������������ڴ���Դ��
 * 		finalize��Object��ķ������������ռ���ִ�е�ʱ�����ñ����ն���Ĵ˷������������ռ�ʱ��������Դ���գ�����ر��ļ��ȡ�
 * 
 * 2.error��exception������
 * 		exception��Ҫthrow��try catch��error��ָ��Ӧ����ͼ����������⣬��Ϊ��Щ�����������Ҳ���ᷢ�����쳣������
 * 		Error��һ����ָ���������ص����⣬��ϵͳ����������������ڴ�ռ䲻�㣬��������ջ��ȡ������������ĵ��µ�Ӧ�ó����жϣ�
 * 	�����������޷��ָ��ͺ�Ԥ�������������Ĵ��󣬽����ó�����ֹ��
 *  	Exception����ʾ�ɻָ������⣬���ǿɲ�׽���ġ�
 *		Java�ṩ��������Ҫ���쳣:runtime exception��checked exception��checked �쳣Ҳ�������Ǿ���������IO�쳣���Լ�SQL�쳣���������쳣��
 *	���������쳣��JAVA������ǿ��Ҫ�����Ǳ���Գ��ֵ���Щ�쳣����catch�����ԣ���������쳣���������Ƿ�Ը�⣬ֻ���Լ�ȥдһ���catch��ȥ������ܵ��쳣��
 *	��������һ���쳣��runtime exception��Ҳ������ʱ�쳣�����ǿ��Բ������������������쳣ʱ��������������ӹܡ�
 *	���磺���Ǵ���û����ȥ�����NullPointerException�쳣������������ʱ�쳣�����������쳣����������쳣֮һ��
 *	
 *3.java���쳣������Ƶ�ԭ��ͼ򵥵�Ӧ��
 *4.5��RuntimeException
 *		ArithmeticException�������쳣��IndexOutOfBoundsException(�Ǳ�Խ��)NullPointException(��ָ���쳣)ArrayStoreException(����洢�쳣�����ʹ���)
 *		NagativeArraySizeException(���鳤�ȸ����쳣)
 * */
public class ExceptionTest {
	public static void main(String[] args) {
		ExceptionTest exceptionTest=new ExceptionTest();
		try{
		System.out.println(exceptionTest.div(5, 0));//���õķ����׳��쳣�����봦����������������try catch��
		}
		catch(DivException e)
		{
			System.out.println(e.toString());
			//System.out.println("���������"+e.getCount());
		}
		
		
	}
	public double div(int a,int b) throws DivException
	{
		if(b==0)
			throw new DivException("��ĸ������0������",b);
		if(b<0)
			throw new DivException("˵��ֻ��ʹ��������Ŷ",b);
		return a/b;
	}
}
 class DivException	extends Exception
{
	private int count;
	public DivException(String name,int count)
	{
		super(name);
		this.count=count;
	}
//	public int getCount()
//	{
//		return count;
//	}
}

