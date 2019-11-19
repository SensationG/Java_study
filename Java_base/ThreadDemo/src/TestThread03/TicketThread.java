package TestThread03;
/*
 * 
 * 	火车票线程
 * 	
 * 
 */
//卖票时实现sleep 休息
/*
 * t1,t2，t3
 * 	假设只剩一张票
 * 	t1过来，发现有票，进入if，但是遇到线程休息
 * 	t2此时过来了，这是t1进入线程休息，票还没卖，所以此时t2进入if，但是遇到线程休息
 * 
 * 	t1休息完毕，回来继续买剩余的一张票
 * 	t2休息完毕，剩下的票被t1卖完了，但因为已经进入循环，所以继续卖 输出-1
 * 
 * 	问题出现条件:
 * 			1.要有多个线程
 * 			2.要有被多个线程所共享的数据
 * 			3.多个线程并发的访问数据
 * 	解决：
 * 		使用synchronized同步锁
 *	格式：
 *		synchronized（锁对象）{
 *
 *		}
 *
 *	注意：锁对象需要被所有的线程所共享
 *	
 */
public class TicketThread implements Runnable{
	int num = 100; //火车票数量 该数量要被所有成员共享
	Object obj = new Object();
	@Override
	public void run() {
		//出售火车票
		while(true) {
			synchronized (obj) {	//同步代码块
				method1();//封装代码 在同步代码块调用方法
			}
			//method1();
		}
	}
	private  void method1() {
		if(num>0) {			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num--;
			System.out.println(Thread.currentThread().getName()+": "+num);
		}
	}

}
