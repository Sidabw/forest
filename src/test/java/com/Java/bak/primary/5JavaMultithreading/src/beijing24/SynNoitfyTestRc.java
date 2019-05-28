package beijing24;

import javax.print.attribute.standard.Sides;

public class SynNoitfyTest {
	public static void main(String[] args) {
		Res res=new Res();
		Input in=new Input(res);
		Output out =new Output(res);
		Thread t1=new Thread(in);
		Thread t2=new Thread(out);
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
class Input implements  Runnable {
	private Res s;
	Input(Res s)
	{
		this.s=s;
	}
	public void run() {
		int i=0;
		while(true)
		{
			synchronized (s) {
				if(s.flag)
				{
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				if(i==0)
				{
					s.name="罗蕾";
					s.sex="女女女女女";
				}
				else// if(i==1)
				{
					s.name="ShaoGuangze";
					s.sex="manmanmanman";
				}
				i++;
				i=i%2;
				s.flag=true;
				s.notify();
			}
		}
	}
}
class Output implements Runnable
{
	private Res s;
	Output(Res s)
	{
		this.s=s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			synchronized (s){
				if(!s.flag)
				{
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				System.out.println("名字是："+s.name+"性别是："+s.sex);
				s.flag=false;
				s.notify();
			}
		
		}
	}
	
}