package TestThread02;
/*
 * 
 * 	多线程实现方式二：创建一个线程是声明实现类Runnable接口。 那个类然后实现了run方法。
 *  然后可 以分配类的实例，在创建Thread时作为参数传递，并启动。
 * 
 *  static Thread currentThread():返回当前线程对象	
 * 
 * 
 */
public class ThreadDemo02 {
	public static void main(String[] args) {
		//1.创建线程实例1
		MyThread2 mt2 = new MyThread2();
		//修改名字
		Thread t2 = new Thread(mt2);
		t2.setName("李四");
		//2.启动线程1
		t2.start();
		
		//1.创建线程实例2
		MyThread2 mt3 = new MyThread2();
		//2.启动线程2
		new Thread(mt3).start();
	}
}
