package TestThread01;
/*
 * 	���̵߳�ʵ�ַ�ʽ��
 * 
 * 	����һ������һ���µ�ִ���߳������ַ����� һ���ǽ�һ��������ΪThread�����ࡣ
 * 			�������Ӧ����дrun��ķ���Thread �� Ȼ����Է��䲢���������ʵ����
 * Thread��
 * 		String getName() ���ظ��̵߳�����
 * 		void SetName(String name) �����߳�name 
 * 
 * CPUִ���̵߳�����ԣ�˭��ִ��û�й���
 */
public class ThreadDemo02 {
	public static void main(String[] args) {
		//1.�����߳�ʵ��0
		MyThread mt = new MyThread();
		//�޸��߳�����
		mt.setName("����");
		//2.�����߳�0
		mt.start();
		
		//1.�����߳�ʵ��1
		MyThread mt2 = new MyThread();
		mt2.setName("����");
		//2.�����߳�1
		mt2.start();
	}
}
