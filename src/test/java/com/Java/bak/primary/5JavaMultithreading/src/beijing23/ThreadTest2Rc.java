package beijing23;

public class ThreadTest2 {
	public static void main(String[] args) {
		Walker walker =new Walker();
		walker.start();
		for(int x=0;x<100;x++)
		{
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			System.out.println("X的值是："+x);
		}
	}
}
class Walker extends Thread{	//继承Thread ,实现 Runnable

	public void run() {
		for(int i=0;i<100;i++)
		{
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			System.out.println("i的值是："+i);
		}
	}
	
}
