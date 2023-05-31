package com.duotai;

public class DuoTaiTest {
	public static void main(String[]args)
	{
		MainBoard M=new MainBoard();
		M.MainBoard_run();
		M.PCI_run(null);
		M.PCI_run(new SoundBoard());	//PCI p= new SoundBoard();
		M.PCI_run(new NetBoard());		//PCI p= new NetBoard();
	}

}
interface PCI
{
	public abstract void open();
	public abstract void close();
}
class MainBoard 
{
	public void MainBoard_run()
	{
		System.out.println("MainBoard_run");
	}
	public void PCI_run(PCI p)
	{
		if (p!=null)
		{
		p.open();
		p.close();
		}
	}
}
class NetBoard implements PCI
{
	public void open()
	
	{
		System.out.println("PCI_NetWork run");
	}
	public void close()
	
	{
		System.out.println("PCI_NetWork end");
	}	
}
class SoundBoard implements PCI
{
	public void open()
	
	{
		System.out.println("PCI_SoundWork run");
	}
	public void close()
	
	{
		System.out.println("PCI_SoundWork end");
	}
		
}
