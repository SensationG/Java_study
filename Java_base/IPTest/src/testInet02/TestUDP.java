package testInet02;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*  ����ΪUDP���Ͷˣ�
 * 
 * 	ʹ��UDPЭ�鷢������
 * 			1.�������Ͷ�Socket����
 * 			2.�������ݲ����
 * 			3.��������
 * 			4.�ͷ���Դ
 * 	
 * 	DatagramSocket�������ʾ���ڷ��ͺͽ������ݱ����ݰ����׽��֣�����UDPЭ��
 * 	���죺
 * 	DatagramSocket()  ����Socket�����������˿ں� 
 * 	DatagramSocket(int port) ����Socket����ָ���˿ں�
 * 
 *  DatagramPacket���ݴ����
 *	���죺
 *	DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
 */
public class TestUDP {
	public static void main(String[] args) throws IOException {
		//1.�������Ͷ�Socket����
		DatagramSocket DS = new DatagramSocket();
		//2.�������ݲ����
		String s = "Hello udp,i am coming��"; //��������
		byte[] bys=s.getBytes();//תΪ�ֽ����� 
		int length = bys.length;
		InetAddress ia = InetAddress.getByName("DESKTOP-RLAFMOV");//���͸���ǰ�豸 �����ݶ����͸��Լ�
		int port = 8888; //�˿ں� �൱�ڿ��д����
		DatagramPacket dPacket = new DatagramPacket(bys, length,ia,port);
		//3.��������
		DS.send(dPacket);
		//4.�ͷ���Դ
		DS.close();
	}
}
