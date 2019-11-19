package testInet05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 * �����
 * 
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//1.����˶���
		ServerSocket ss = new ServerSocket(7070);
		//2.�����ͻ����Ƿ�����
		Socket sk = ss.accept();
		//3.����������
		InputStream is = sk.getInputStream();	
		//4.��ȡ����
		byte[] data = new byte[1024];
		int len;
		len = is.read(data);		
		//ת������
		String str = new String(data,0,len);
		//5.�������
		System.out.println(str);
		//��������
		String upperStr = str.toUpperCase();
		//��ΰѷ������Ϣ���ؿͻ��ˣ��ͻ������д������д��ȥ����
		//��ȡ��������� 
		OutputStream os = sk.getOutputStream();
		//��������
		os.write(upperStr.getBytes());
		
		//6.�ͷ���Դ
		sk.close();
	}
}
