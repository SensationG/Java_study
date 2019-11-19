package TestThread02;
/*
 * 	第二种多线程方式
 * 	实现Runnable类
 * 
 */
public class MyThread2 implements Runnable{
	@Override
	public void run() {
		for(int i = 0;i<100;i++) {
			//实现了Runnable接口 但无getName方法 所以使用.currentThread();返回对当前正在执行的线程对象的引用。 
			//可以1：
			//Thread t = new Thread().currentThread();
			//System.out.println(t.getName()+" "+i);
			
			//也可以2：链式编程
			System.out.println(Thread.currentThread().getName()+" "+i);	
		}
	}
}
