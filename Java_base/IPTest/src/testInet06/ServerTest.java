package testInet06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 * ��������
 * 
 */
public class ServerTest {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10092);
		//����
		Socket s = ss.accept();
		//����������
		BufferedReader bReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//��ȡdata һ�ζ�ȡһ��
		String username = bReader.readLine();
		String password = bReader.readLine();
		//�ж�
		boolean flag = false; //�����ж� Ĭ��Ϊfalse �Ͳ���дelse
		if("hhw2019".equals(username) || "hhw1234".equals(password)) {
			flag = true;
		}
		//������Ϣ new �����
		OutputStream os = s.getOutputStream();
		if(flag) {
			os.write("��½�ɹ�".getBytes());
		}else {
			os.write("��½ʧ��".getBytes());
		}
		//�ͷ���Դ
		s.close();
		ss.close();
	}
}
