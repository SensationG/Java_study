package TestThread03;
/*
 * 
 * 	��Ʊ�߳�
 * 	
 * 
 */
//��Ʊʱʵ��sleep ��Ϣ
/*
 * t1,t2��t3
 * 	����ֻʣһ��Ʊ
 * 	t1������������Ʊ������if�����������߳���Ϣ
 * 	t2��ʱ�����ˣ�����t1�����߳���Ϣ��Ʊ��û�������Դ�ʱt2����if�����������߳���Ϣ
 * 
 * 	t1��Ϣ��ϣ�����������ʣ���һ��Ʊ
 * 	t2��Ϣ��ϣ�ʣ�µ�Ʊ��t1�����ˣ�����Ϊ�Ѿ�����ѭ�������Լ����� ���-1
 * 
 * 	�����������:
 * 			1.Ҫ�ж���߳�
 * 			2.Ҫ�б�����߳������������
 * 			3.����̲߳����ķ�������
 * 	�����
 * 		ʹ��synchronizedͬ����
 *	��ʽ��
 *		synchronized��������{
 *
 *		}
 *
 *	ע�⣺��������Ҫ�����е��߳�������
 *	
 */
public class TicketThread implements Runnable{
	int num = 100; //��Ʊ���� ������Ҫ�����г�Ա����
	Object obj = new Object();
	@Override
	public void run() {
		//���ۻ�Ʊ
		while(true) {
			synchronized (obj) {	//ͬ�������
				method1();//��װ���� ��ͬ���������÷���
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
