package testInet04;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 	����ˣ����նˣ�
 * 	ʹ��TCPЭ���������
 * 			1.�������ն�Socket����
 * 			2.���� ���ȴ����Ͷ˿ͻ������ӣ�
 * 			3. �������������
 * 			4.��ȡ����
 * 			5.�������
 * 			6.�ͷ���Դ
 * 
 */
public class TestTCPReceive {
	public static void main(String[] args) throws IOException {
		//1.�������ն�Socket����
		ServerSocket ss = new ServerSocket(10089);
		//2.���� ���ȴ����Ͷ˿ͻ������ӣ�
		Socket s = ss.accept();
		//3. �������������
		InputStream is = s.getInputStream();
		//4.��ȡ����
		byte[] bys = new byte[1024];
		int len;//	���ڴ洢�������ֽڸ���
		len = is.read(bys);//һ�ζ�ȡһ���ַ����� 
		//5.�������
		System.out.println(new String(bys,0,len));
		//6.�ͷ���Դ
		s.close();
		//ss.close();//��������һ�㲻��
	}
}
