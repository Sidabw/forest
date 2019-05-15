package beijing23;
/**
 * 死锁解释：
 * 如果线程1锁住了A，然后尝试对B进行加锁，同时线程2已经锁住了B，接着尝试对A进行加锁，这时死锁就发生了。
 * 线程1永远得不到B，线程2也永远得不到A，并且它们永远也不会知道发生了这样的事情。
 * 为了得到彼此的对象（A和B），它们将永远阻塞下去。这种情况就是一个死锁。
 * */
public class DeadLockTest9  implements Runnable {
	public int flag=1;
	static Object object1=new Object();
	static Object object2=new Object();
	
	public static void main(String[] args) {
		DeadLockTest9 t1=new DeadLockTest9();
		DeadLockTest9 t2=new DeadLockTest9();
		Thread td1=new Thread(t1);
		Thread td2=new Thread(t2);
		t1.flag=1;
		t2.flag=2;
		td1.start();
		td2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(flag==1){
			System.out.println("flag="+flag);
			synchronized(object1){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName()+"还差object2");
				synchronized(object2){
					System.out.println("2");
				}
		}
		}
		if(flag==2)
		{
			System.out.println("flag="+flag);
			synchronized(object2){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName()+"还差object1");
				synchronized(object1){
					System.out.println("1");
				}
		}
	}
}
}
