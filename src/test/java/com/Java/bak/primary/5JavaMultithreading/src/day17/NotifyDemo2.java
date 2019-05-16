package day17;

public class NotifyDemo2 {
	public static void main(String[] args)
	{
	Res r=new Res();
	new Thread(new Input(r)).start();
	new Thread(new Output(r)).start();
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
				r.set("����", "ŮŮŮŮŮ");
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