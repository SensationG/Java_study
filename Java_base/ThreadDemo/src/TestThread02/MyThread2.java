package TestThread02;
/*
 * 	�ڶ��ֶ��̷߳�ʽ
 * 	ʵ��Runnable��
 * 
 */
public class MyThread2 implements Runnable{
	@Override
	public void run() {
		for(int i = 0;i<100;i++) {
			//ʵ����Runnable�ӿ� ����getName���� ����ʹ��.currentThread();���ضԵ�ǰ����ִ�е��̶߳�������á� 
			//����1��
			//Thread t = new Thread().currentThread();
			//System.out.println(t.getName()+" "+i);
			
			//Ҳ����2����ʽ���
			System.out.println(Thread.currentThread().getName()+" "+i);	
		}
	}
}
