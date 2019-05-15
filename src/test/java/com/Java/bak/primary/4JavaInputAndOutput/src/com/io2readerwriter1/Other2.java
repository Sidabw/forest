package com.io2readerwriter1;
/*
 * 装饰者模式作业：儿子的工作是画画，母亲的工作是不止画画，还上涂料，爸爸的工作室再母亲的基础上，不止画画，上涂料，还上画框
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
		System.out.println("画画");
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
		System.out.println("上涂料啦~~");
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
		System.out.println("上框");
	}
	
}