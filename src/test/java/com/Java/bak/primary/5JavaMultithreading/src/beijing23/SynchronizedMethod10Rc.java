package beijing23;

public class SynchronizedMethod10<synchronizedvoid>	implements Runnable  {
	int b=1;
	public static void main(String[] args) throws InterruptedException {
		
		SynchronizedMethod10 sm=new SynchronizedMethod10<>();
		Thread t=new Thread(sm);
		t.start();
		sm.m2();
		System.out.println("b的值为："+sm.b);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			m1();
			//Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public synchronized void m1() throws InterruptedException{
		b=1000;
		Thread.sleep(2000);
		System.out.println("b="+b);
	}
	public void m2() throws InterruptedException{
		Thread.sleep(5000);
		b=2000;
	}
}
