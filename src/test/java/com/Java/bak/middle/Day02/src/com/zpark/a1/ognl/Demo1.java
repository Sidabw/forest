package com.Java.bak.middle.Day02.src.com.zpark.a1.ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.zpark.entity.User;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class Demo1 {
	public void fun1() throws OgnlException{
		User u=new User("Sida",23,"1234567890");
		Map<String,String> m=new HashMap<String,String>();
		m.put("Sida", "beauty girl");
		OgnlContext ognlContext = new OgnlContext();
		ognlContext.setRoot(u);
		ognlContext.setValues(m);
		//��ȡRoot�ж��������
		Object value = Ognl.getValue("age",m,u);
		System.out.println(value);
		//��ȡcontext ��map��key��Ӧ��value
		Object value2 = Ognl.getValue("#Sida", m,u);
		System.out.println(value2);
	}
	@Test
	public void fun2() throws OgnlException{
		Map<String,User> m=new HashMap<String,User>();
		m.put("Brew", new User("Brew",23,"987654321"));
		User user = new User("luobotou",21,"1234567890");
		OgnlContext ognlContext = new OgnlContext();
		ognlContext.setRoot(user);
		ognlContext.setValues(m);
		//��map�д�Ŷ���ʱ����ȡ������
		Object value = Ognl.getValue("#Brew.age",m,user);
		System.out.println(value);
	}
}
