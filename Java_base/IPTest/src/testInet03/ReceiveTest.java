package testInet03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 
 * 	���ն˲���
 * 
 * 
 */
public class ReceiveTest {
	public static void main(String[] args) throws IOException {
		//1.���ն� ����port �뷢�Ͷ�һ��
		DatagramSocket ds =new DatagramSocket(9999);
		//2.����������
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);
		//3.����
		ds.receive(dp);
		//4.���
		byte[] data = dp.getData();
		InetAddress address = dp.getAddress();
		int length = dp.getLength();
		//5.���
		System.out.println("send from------> "+address.getHostName());
		System.out.println(new String(data,0,length));
		//6.�ͷ���Դ
		ds.close();
	}
}
