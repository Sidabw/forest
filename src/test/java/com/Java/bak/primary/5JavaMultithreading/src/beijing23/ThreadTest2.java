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
			System.out.println("X��ֵ�ǣ�"+x);
		}
	}
}
class Walker extends Thread{	//�̳�Thread ,ʵ�� Runnable

	public void run() {
		for(int i=0;i<100;i++)
		{
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			System.out.println("i��ֵ�ǣ�"+i);
		}
	}
	
}
