package TestThread03;
/*
 * 
 * 	���̻߳�Ʊ������
 * 		������
 * 			������Ҫ�л�Ʊ����������ÿ�۳�һ����������һ
 * 			����Ʊ����С��1����ֹͣ��Ʊ
 * 			ʹ�ö��߳�ģ������Ʊ���ڽ�����Ʊ
 * 			����Ʊȫ�����꣬��Ʊ�����ţ��̲߳��أ�
 * 		
 * 		static void sleep(long millis) : �õ�ǰ�߳�˯һ��
 */
public class ThreadTrain01 {
	public static void main(String[] args) {
		//1.�����̶߳���
		TicketThread tt1 = new TicketThread();
		
		Thread t1 = new Thread(tt1);
		t1.setName("����1");
		Thread t2 = new Thread(tt1);
		t2.setName("����2");
		Thread t3 = new Thread(tt1);
		t3.setName("����3");
		
		
		//2.ִ���߳�
		t1.start();
		t2.start();
		t3.start();
	}
}
