package com.duotai;

public class abstractDemo {
	public static void main(String[] args)
	{
		Manager M=new Manager("zhangsan","jishubu01",76,87);
		M.work();
		
	}

}
abstract class employee
{
	String name;
	String id;
	int pay;
	employee(String name,String id,int pay) 
	{
		this.name=name;
		this.id=id;
		this.pay=pay;
		System.out.println(name+id+pay);
	}
	public abstract void work();
}
class Manager extends employee
{
	int bonus;
	Manager(String name,String id,int pay,int bonus)
	{
		super(name,id,pay);
		this.bonus=bonus;
		System.out.println(name +id +pay +bonus);
	}
	public void work()								//子类需要覆盖父类的全部abstract方法
	{
		System.out.println("manager work");
	}
}
