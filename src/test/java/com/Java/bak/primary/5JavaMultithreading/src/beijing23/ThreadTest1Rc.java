package beijing23;

/*
 * Sychronized
 * 
 * 		1.成员锁
 * 			1..方法声明时使用(不参与继承,修饰静态方法时锁定的这个类的所有对象),放在范围操作符(public等)之后,返回类型声明(void等)之前，锁住的是Sychronized所在的方法public synchronized void synMethod() {}
 * 				1.1	方法所的另一种写法，就是将虚拟对象所放到方法中:bject obj =new Object();Sychronized(obj){}	虚拟对象锁， 别的线程还可以对此对象进行除此方法外的其他操作
 * 		2.对象锁
 * 			1.synchronized (this) {}别的线程在该类所有对象上的任何操作都不能进行,除了静态变量和静态方法，因为静态变量和静态方法是在类上而不是在对象上
 * 			3.synchronized后面括号里是类,此时,线程获得的是对象锁	Sychronized(Single.class)如果线程进入,则线程在该类中所有操作不能进行,包括静态变量和静态方法
 * 
 * 
 * */
public class ThreadTest1 {
	public static void main(String[] args) {
		Runner runner=new Runner();
		Thread t1=new Thread(runner);
		t1.start();
		for(int x=0;x<100;x++)	//t1 线程与main线程同时运行，如果不加Thread.sleep(100)的话很难看出两个线程在交叉运行
		{
			try{Thread.sleep(100);}catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread()+"x="+x);
		}
	}
}
class Runner implements Runnable
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
		{
			try{Thread.sleep(100);}catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread()+"i="+i);
		}
	}
	
}
