package testInet05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 
 * 	����ʹ��TCPЭ�鷢�����ݣ��������յ�������ת���ɴ�д������
 * 
 * 	�ͻ���
 * 
 */
public class Demo1 {
	public static void main(String[] args) throws IOException, IOException {
		//1.tcpЭ�� ����Ŀ��
		Socket sk = new Socket(InetAddress.getByName("DESKTOP-RLAFMOV"), 7070);
		//2.������������� 
		OutputStream ops = sk.getOutputStream();
		//3.��������
		ops.write("hello,this is a tcp test".getBytes());
		//�������� ����������
		InputStream is = sk.getInputStream();
		byte[] bys = new byte[1024];
		int len;
		len = is.read(bys);
		System.out.println(new String(bys,0,len));
		//4.�ͷ���Դ
		sk.close();
	}
}
