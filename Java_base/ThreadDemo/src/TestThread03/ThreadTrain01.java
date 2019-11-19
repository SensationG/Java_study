package TestThread03;
/*
 * 
 * 	多线程火车票案例：
 * 		分析：
 * 			首先需要有火车票的总数量，每售出一张则总数减一
 * 			当火车票数量小于1，则停止售票
 * 			使用多线程模拟多个售票窗口进行售票
 * 			当火车票全部收完，火车票不关门（线程不关）
 * 		
 * 		static void sleep(long millis) : 让当前线程睡一会
 */
public class ThreadTrain01 {
	public static void main(String[] args) {
		//1.创建线程对象
		TicketThread tt1 = new TicketThread();
		
		Thread t1 = new Thread(tt1);
		t1.setName("窗口1");
		Thread t2 = new Thread(tt1);
		t2.setName("窗口2");
		Thread t3 = new Thread(tt1);
		t3.setName("窗口3");
		
		
		//2.执行线程
		t1.start();
		t2.start();
		t3.start();
	}
}
