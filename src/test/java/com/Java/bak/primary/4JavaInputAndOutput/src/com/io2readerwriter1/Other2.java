package com.io2readerwriter1;
/*
 * װ����ģʽ��ҵ�����ӵĹ����ǻ�����ĸ�׵Ĺ����ǲ�ֹ����������Ϳ�ϣ��ְֵĹ�������ĸ�׵Ļ����ϣ���ֹ��������Ϳ�ϣ����ϻ���
 * 
 * 
 * 
 * */
public class Other2 {
	public static void main(String[] args) {
		Son son=new Son();
		Mother mother =new Mother(son);
//		mother.work();
		
		Father father=new Father(mother);
		father.work();
	}
}
interface Work
{
	public abstract void work();
}
class Son implements Work
{

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}
	
}
class Mother implements Work
{
	Work worker;
	 public Mother(Work worker) {
		// TODO Auto-generated constructor stub
		this.worker =worker;
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		worker.work();
		System.out.println("��Ϳ����~~");
	}
	
}
class Father implements Work{
	Work worker;
	public Father(Work worker) {
		// TODO Auto-generated constructor stub
	this.worker=worker;
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		worker.work();
		System.out.println("�Ͽ�");
	}
	
}