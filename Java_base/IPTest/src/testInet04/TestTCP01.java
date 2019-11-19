package testInet04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/*
 * 	�ͻ��ˣ����Ͷˣ�
 * 	ʹ��TCPЭ�鷢������
 * 			1.�������Ͷ�Socekt���󣨴������ӣ� 
 * 			2.��ȡ��������󣨴�Socket��ȡ��
 * 			3.��������
 * 			4.�ͷ���Դ
 * 
 * Socket(InetAddress address, int port) �������׽��ֲ��������ӵ�ָ��IP��ַ��ָ���˿ںš� 
 */
public class TestTCP01 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.�������Ͷ�Socket����
		Socket s = new Socket(InetAddress.getByName("DESKTOP-RLAFMOV"),10089);
		//2.��ȡ��������󣨴�Socket��ȡ��
		OutputStream os = s.getOutputStream();
		//3.��������
		String str = "Hello ,this is TCP";
		os.write(str.getBytes());
		//4.�ͷ���Դ
		//os.close();
		s.close();
	}
}
