package com.midtermtest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test5 {
	public static void main(String[] args) {
		Course c=new Course();
		HashMap<Integer, String> hMap=c.courseList();
		Student lblbt=new Student("luolei", 001);
		lblbt.setCourse(hMap, 0001);//选课
		lblbt.setCourse(hMap, 0002);//选课
/*
 *检验选课完成后原来的课程是否减少。
		Set<Map.Entry<Integer, String>> mEntry=hMap.entrySet();
		Iterator<Entry<Integer, String>> it=mEntry.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
 */
		lblbt.modifyCourse(lblbt.ReturnSetCourse(), hMap, 0001, 0003);//修改所选课程。需要传4个参数，分别是Student的选课集合stuhMap，
																		//Course的课程列表集合hMap，Student中要删除的课程，Course中要
																		//添加的课程(Student加了之后删，COUrse加了之后删，4步操作)。
																		//其中前两个集合都是调用对象的的方法返回来的。
		lblbt.viewCourse();		//查看已选课程	
	}
}
class Course
{
	public HashMap<Integer, String> courseList()
	{
		HashMap<Integer, String> course=new HashMap<Integer,String>();
		course.put(0001,"高等数学");
		course.put(0002,"专业英语");
		course.put(0003,"毛泽东思想");
		course.put(0004,"邓小平理论");
		course.put(0005,"java开发与项目实践");
		course.put(0006,"高频概述");
		return course;
	}
}
class Student
{
	private String name;
	private int id;
	HashMap<Integer, String> stuhMap=new HashMap<Integer,String>();
	public Student(String name,int id)
	{
		this.name=name;
		this.id=id;
	}
	public void setCourse(HashMap<Integer, String> hMap,Integer number )//选择课程
	{
		stuhMap.put(number,hMap.get(number));
		hMap.remove(number);
	}
	public HashMap<Integer, String> ReturnSetCourse()
	{
		return stuhMap;
	}
	public void viewCourse()		//查看课程
	{
		System.out.println("姓名："+this.name+"	"+"id:"+this.id);
		System.out.println("当前已选课程为：");
		Set<Map.Entry<Integer, String>> mEntry=stuhMap.entrySet();
		Iterator<Entry<Integer, String>> it=mEntry.iterator();
		while(it.hasNext())
		{
			Entry<Integer, String> entry=it.next();
			System.out.println("课程序号为："+entry.getKey()+"	"+"课程名称为："+entry.getValue());
		}
	}
	public void modifyCourse(HashMap<Integer, String> stuMap,HashMap<Integer, String> course,Integer stuNumber,Integer couNumber)
	{
		//stuNumber	stuMap中已选的课程序号
		//couNumber course中已选的课程序号
		stuMap.put(couNumber,course.get(couNumber));
		course.put(stuNumber, stuMap.get(stuNumber));
		stuMap.remove(stuNumber);
		course.remove(couNumber);
	}	
}