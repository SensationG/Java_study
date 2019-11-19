package testInet02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.xml.crypto.Data;

/*
 * 
 * UDPЭ����ն�
 * 		1.�������ն�Socket����
 * 		2.��������
 * 		3.�������ݣ������
 * 		4.�������
 * 		5.�ͷ���Դ
 * 
 */
public class TestUDP02 {
	public static void main(String[] args) throws IOException {
		//1.�������ն�Socket����
		DatagramSocket dSocket = new DatagramSocket(8888); //ָ���˿ں�
		//2.��������
		byte[] byt = new byte[1024];//newһ���ֽ����� ������������ 
		DatagramPacket dp = new DatagramPacket(byt, byt.length);//�������ݵİ�����
		System.out.println("1");
		dSocket.receive(dp);//���� �ȴ����ݹ���
		System.out.println("2");
		//3.�������ݣ������
		InetAddress iAddress = dp.getAddress();//��ȡ���Ͷ˵�ip����
		byte[] data = dp.getData();//��ȡ���յ������ݣ�Ҳ����ֱ��ʹ�ô���������ʱ������ ������byt
		int length = dp.getLength();//��ȡ�����յ����ݵĳ��� ��������������� 
		//4.�������
		 System.out.println("send----->"+iAddress.getHostAddress());//���ط�����ip
		 System.out.println(new String(data,0,length));//�յ�����ת���٣���Ȼ���п��ֽ� 
		//5.�ͷ���Դ
		 dSocket.close();
	}
}
