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
		lblbt.setCourse(hMap, 0001);//ѡ��
		lblbt.setCourse(hMap, 0002);//ѡ��
/*
 *����ѡ����ɺ�ԭ���Ŀγ��Ƿ���١�
		Set<Map.Entry<Integer, String>> mEntry=hMap.entrySet();
		Iterator<Entry<Integer, String>> it=mEntry.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
 */
		lblbt.modifyCourse(lblbt.ReturnSetCourse(), hMap, 0001, 0003);//�޸���ѡ�γ̡���Ҫ��4���������ֱ���Student��ѡ�μ���stuhMap��
																		//Course�Ŀγ��б���hMap��Student��Ҫɾ���Ŀγ̣�Course��Ҫ
																		//��ӵĿγ�(Student����֮��ɾ��COUrse����֮��ɾ��4������)��
																		//����ǰ�������϶��ǵ��ö���ĵķ����������ġ�
		lblbt.viewCourse();		//�鿴��ѡ�γ�	
	}
}
class Course
{
	public HashMap<Integer, String> courseList()
	{
		HashMap<Integer, String> course=new HashMap<Integer,String>();
		course.put(0001,"�ߵ���ѧ");
		course.put(0002,"רҵӢ��");
		course.put(0003,"ë��˼��");
		course.put(0004,"��Сƽ����");
		course.put(0005,"java��������Ŀʵ��");
		course.put(0006,"��Ƶ����");
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
	public void setCourse(HashMap<Integer, String> hMap,Integer number )//ѡ��γ�
	{
		stuhMap.put(number,hMap.get(number));
		hMap.remove(number);
	}
	public HashMap<Integer, String> ReturnSetCourse()
	{
		return stuhMap;
	}
	public void viewCourse()		//�鿴�γ�
	{
		System.out.println("������"+this.name+"	"+"id:"+this.id);
		System.out.println("��ǰ��ѡ�γ�Ϊ��");
		Set<Map.Entry<Integer, String>> mEntry=stuhMap.entrySet();
		Iterator<Entry<Integer, String>> it=mEntry.iterator();
		while(it.hasNext())
		{
			Entry<Integer, String> entry=it.next();
			System.out.println("�γ����Ϊ��"+entry.getKey()+"	"+"�γ�����Ϊ��"+entry.getValue());
		}
	}
	public void modifyCourse(HashMap<Integer, String> stuMap,HashMap<Integer, String> course,Integer stuNumber,Integer couNumber)
	{
		//stuNumber	stuMap����ѡ�Ŀγ����
		//couNumber course����ѡ�Ŀγ����
		stuMap.put(couNumber,course.get(couNumber));
		course.put(stuNumber, stuMap.get(stuNumber));
		stuMap.remove(stuNumber);
		course.remove(couNumber);
	}	
}