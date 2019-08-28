package day17;

public class NotifyDemo2 {
	public static void main(String[] args)
	{
	Res1 r=new Res1();
	new Thread(new Input1(r)).start();
	new Thread(new Output1(r)).start();
	}
}
class Res1
{
	private String name;
	private String sex;
	private boolean flag=false;
	public synchronized void set(String name,String sex)
	{
		if(flag)
			try{this.wait();}catch(Exception e){}
		this.name=name;
		this.sex=sex;
		this.notify();
		
		
	}
	public synchronized void out()
	{
		if(!flag)
			try{wait();}catch(Exception e){}
		System.out.println(name+"........."+sex);
		this.notify();
	}
	
}
class Input1 implements Runnable
{
	private Res1 r;
	Input1(Res1 r)
	{
		this.r=r;
	}
	public void run()
	{
		int x=0;
		while(true)
		{
			if(x==0)
				r.set("milk", "man");
			else
				r.set("丽丽", "女女女女女");
			x=(x+1)%2;
		}
		
	}
}
class Output1 implements Runnable 
{
	private Res1 r;
	Output1(Res1 r)
	{
		this.r=r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
		
	}
	
}