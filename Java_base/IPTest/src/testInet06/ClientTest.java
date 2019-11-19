package testInet06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

/*
 * 
 * ģ���û���½
 * 
 * �ͻ���
 * 
 * 
 */
public class ClientTest {
	public static void main(String[] args) throws IOException {
		//1.�����ͻ���Socket����
		//Socket s = new Socket(InetAddress.getByName("DESKTOP-RLAFMOV"),10092);
		Socket s = new Socket("DESKTOP-RLAFMOV",10092);
		//2.��ȡ�û���������(һ�ζ�һ�У�һ���û���һ������)
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û�����");
		String username = bReader.readLine();
		System.out.println("���������룺");
		String password = bReader.readLine();
		//3.��ȡ����������ʹ�ô�ӡ�����ɻ���+�Զ�ˢ�£�
		PrintWriter outWriter = new PrintWriter(s.getOutputStream(),true);
		//4.д������(�÷�����������)
		outWriter.println(username);
		outWriter.println(password);
		//5.��ȡ����������
		InputStream is = s.getInputStream();
		//6.��ȡ���������ص�����
		byte[] bys = new byte[1024];
		int len;
		len = is.read(bys);
		System.out.println(new String(bys,0,len));
		//7.�ͷ���Դ
		s.close();
	}
}
