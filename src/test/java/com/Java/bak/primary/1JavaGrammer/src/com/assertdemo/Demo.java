package com.assertdemo;

public class Demo {
	/**
	 * 断言 expression 为 true 。 实际结果为false 时 抛出Throwable的子类AssertError。
	 * 右键run configuration ，arguments vm arguments 加入 -ea
	 * */
	public static void main(String[] args){
		
		//Test1
		/*boolean flag = 1>2;
		assert flag;*/
		
		//Test2
		boolean flag = 1>2;
		assert flag : "这里本应该为true";
				
	}
}
