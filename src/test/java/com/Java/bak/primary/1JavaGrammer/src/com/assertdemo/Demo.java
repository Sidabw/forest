package com.assertdemo;

public class Demo {
	/**
	 * ���� expression Ϊ true �� ʵ�ʽ��Ϊfalse ʱ �׳�Throwable������AssertError��
	 * �Ҽ�run configuration ��arguments vm arguments ���� -ea
	 * */
	public static void main(String[] args){
		
		//Test1
		/*boolean flag = 1>2;
		assert flag;*/
		
		//Test2
		boolean flag = 1>2;
		assert flag : "���ﱾӦ��Ϊtrue";
				
	}
}
