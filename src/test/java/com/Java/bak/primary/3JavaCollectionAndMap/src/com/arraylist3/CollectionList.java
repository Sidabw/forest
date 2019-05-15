package com.arraylist3;
/*
 * List:Ԫ��������ģ������ظ�����Ϊ�ü���������

 * 		|---ArrayList:	�ײ�����ݽṹʹ�õ�������ṹ���ص㣺��ѯ�ٶȿ죬������ɾ����		�̲߳�ͬ��
 * 		|---LinkList:	�ײ�ʹ�õ����������ݽṹ     	�ص㣺��ѯ�ٶ�������ɾ�ٶȿ�
 * 						�ڲ�ѯ��ʱ����Ȼͬ�����Ե���LinkedList��get(index)������������Ȼ�Ǵӵ�0 index��ʼ��ѯ��ֱ���ҵ�index��Ӧ��Ԫ��
 * 		|---Vector:		�ײ����������ݽṹ 		�߳�ͬ��
 * Set:Ԫ��������ģ� Ԫ�ز����ظ�
 * 
 * List���з��������Բ����Ǳ�
 * ��
 * ɾ
 * ��
 * ��
 * List�������еĵ�������ListIterator��Iterator���ӽӿ�
 * �ڵ���ʱ��������ʹ�ü��϶���ķ����������ϵ�Ԫ��
 * �ᷢ���쳣ConcurrentModificationException
 * 
 * */
import java.util.*;

public class CollectionList {
	public static void main(String[] args)
	{
		//�б������  ListIterator
		ArrayList al=new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		System.out.println(al);
		ListIterator li=al.listIterator();		
		while(li.hasNext())		// �������
		{
			Object obj=li.next();
			
			System.out.println(obj);
			if(obj.equals("java02"))
				//li.add("java09");
				li.set("java06");// ListIterator�е� set��E e)��������ָ��Ԫ���滻 next �� previous ���ص����һ��Ԫ��
		}		
		System.out.println(al);
		while(li.hasPrevious())		//�����������֮���α괦�����һ��Ԫ�صĺ��棬���Ե���ListIterator���hasPrevious�᷵��ture
		{
			System.out.println(li.previous());
		}
		System.out.println("----------------------------------------------------");
		method();
	}
	public static void method()
	{
		ArrayList al=new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		//��ָ��λ�����Ԫ��
		al.add(1,"java09");                                                           
		System.out.println(al);
		//ɾ��ָ��λ�õ�Ԫ��
		al.remove(2);
		System.out.println(al);
		//�޸�Ԫ��
		al.set(2, "javaLL");
		System.out.println(al);
		//ͨ���Ǳ��ȡԪ��
		System.out.println(al.get(1));
		//��ȡ����Ԫ��-------->����
		for(int x=0;x<al.size();x++)	
		{
			System.out.println("al("+x+")="+al.get(x));
		}
		
		for(Iterator it=al.iterator();it.hasNext();)
		{
			System.out.println(it.next());
		}
		//ͨ��indexOf��ȡ�����λ��
		System.out.println(al.indexOf("javaLL"));
		//��ȡ���б�
		List sub=al.subList(1, 2);		//��ͷ����β
		System.out.println(sub);
	}

}
