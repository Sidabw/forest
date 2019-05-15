package com.exceptiontest;
/*
 * 1.java中final finally finalize的区别？
 * 		final是修饰的属性不可更改，修饰的方法不可被子类复写，修饰的类不可被继承
 * 		finally是异常处理机制中一定执行的代码。使用 finally 可以维护对象的内部状态，并可以清理非内存资源。
 * 		finalize是Object类的方法，在垃圾收集器执行的时候会调用被回收对象的此方法，供垃圾收集时的其他资源回收，例如关闭文件等。
 * 
 * 2.error和exception的区别？
 * 		exception需要throw并try catch。error是指不应当试图被捕获的问题，因为这些错误可能是再也不会发生的异常条件。
 * 		Error类一般是指与虚拟机相关的问题，如系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢等。对于这类错误的导致的应用程序中断，
 * 	仅靠程序本身无法恢复和和预防，遇到这样的错误，建议让程序终止。
 *  	Exception：表示可恢复的例外，这是可捕捉到的。
 *		Java提供了两类主要的异常:runtime exception和checked exception。checked 异常也就是我们经常遇到的IO异常，以及SQL异常都是这种异常。
 *	对于这种异常，JAVA编译器强制要求我们必需对出现的这些异常进行catch。所以，面对这种异常不管我们是否愿意，只能自己去写一大堆catch块去处理可能的异常。
 *	但是另外一种异常：runtime exception，也称运行时异常，我们可以不处理。当出现这样的异常时，总是由虚拟机接管。
 *	比如：我们从来没有人去处理过NullPointerException异常，它就是运行时异常，并且这种异常还是最常见的异常之一。
 *	
 *3.java中异常处理机制的原理和简单的应用
 *4.5个RuntimeException
 *		ArithmeticException（算数异常）IndexOutOfBoundsException(角标越界)NullPointException(空指针异常)ArrayStoreException(数组存储异常，类型错误)
 *		NagativeArraySizeException(数组长度负数异常)
 * */
public class ExceptionTest {
	public static void main(String[] args) {
		ExceptionTest exceptionTest=new ExceptionTest();
		try{
		System.out.println(exceptionTest.div(5, 0));//调用的方法抛出异常，必须处理（方法上声明或者try catch）
		}
		catch(DivException e)
		{
			System.out.println(e.toString());
			//System.out.println("错误的数是"+e.getCount());
		}
		
		
	}
	public double div(int a,int b) throws DivException
	{
		if(b==0)
			throw new DivException("分母不能是0！！！",b);
		if(b<0)
			throw new DivException("说好只能使用正数的哦",b);
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

