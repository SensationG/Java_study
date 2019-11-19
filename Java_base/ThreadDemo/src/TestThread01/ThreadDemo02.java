package TestThread01;
/*
 * 	多线程的实现方式：
 * 
 * 	方法一：创建一个新的执行线程有两种方法。 一个是将一个类声明为Thread的子类。
 * 			这个子类应该重写run类的方法Thread 。 然后可以分配并启动子类的实例。
 * Thread类
 * 		String getName() 返回该线程的名字
 * 		void SetName(String name) 更改线程name 
 * 
 * CPU执行线程的随机性，谁先执行没有规律
 */
public class ThreadDemo02 {
	public static void main(String[] args) {
		//1.创建线程实例0
		MyThread mt = new MyThread();
		//修改线程名字
		mt.setName("张三");
		//2.启动线程0
		mt.start();
		
		//1.创建线程实例1
		MyThread mt2 = new MyThread();
		mt2.setName("老外");
		//2.启动线程1
		mt2.start();
	}
}
