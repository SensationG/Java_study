package TestThread02;
/*
 * 
 * 	���߳�ʵ�ַ�ʽ��������һ���߳�������ʵ����Runnable�ӿڡ� �Ǹ���Ȼ��ʵ����run������
 *  Ȼ��� �Է������ʵ�����ڴ���Threadʱ��Ϊ�������ݣ���������
 * 
 *  static Thread currentThread():���ص�ǰ�̶߳���	
 * 
 * 
 */
public class ThreadDemo02 {
	public static void main(String[] args) {
		//1.�����߳�ʵ��1
		MyThread2 mt2 = new MyThread2();
		//�޸�����
		Thread t2 = new Thread(mt2);
		t2.setName("����");
		//2.�����߳�1
		t2.start();
		
		//1.�����߳�ʵ��2
		MyThread2 mt3 = new MyThread2();
		//2.�����߳�2
		new Thread(mt3).start();
	}
}
