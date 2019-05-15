package day17;

public class NotifyDemo {
	public static void main(String[] args)
	{
		Res r=new Res();
		Input in =new Input(r);
		Output out=new Output(r);
		Thread t1=new Thread(in);
		Thread t2= new Thread(out);
		t1.start();
		t2.start();
		
	}

}
class Res
{
	 String name;
	 String sex;
	 boolean flag=false;
	
}

class Input implements Runnable
{
	private Res r;
	Input(Res r)
	{
		this.r=r;
	}
	public void run()
	{
		int x=0;
		while(true)
		{
			synchronized(r)
			{
				if(r.flag)
				try{r.wait();}catch(Exception e){}
					if(x==0)
					{
						r.name="milk";
						r.sex="man";
					}
					else
					{
						r.name="丽丽";
						r.sex="女女女女女女";
					}
					x++;
					x=x%2;
					r.flag=true;
					r.notify();

			}
		}
	}
	
}
class Output implements Runnable
{
	private Res r;
	Output(Res r)
	{
		this.r=r;
	}
	public void run()
	{
		while(true)
		{
			synchronized(r)
			{
				if(!r.flag)
					try{r.wait();}catch(Exception e){}
			System.out.println(r.name+"........"+r.sex);
				r.flag=false;
				r.notify();
			}
		}
		
	}
	
}