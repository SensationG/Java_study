package testInet03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 	���Ͷ˲���
 * 
 * 
 */
public class SendTest {
	public static void main(String[] args) throws IOException {
		//1.���Ͷ˶���
		DatagramSocket ds = new DatagramSocket();
		//2.���
		byte[] bys = "Helloooo,this is UDP".getBytes();
		InetAddress iAddress = InetAddress.getByName("DESKTOP-RLAFMOV");
		DatagramPacket dp = new DatagramPacket(bys, bys.length, iAddress, 9999);
		//3.����
		ds.send(dp);
		//4.�ͷ�
		ds.close();
	}
}
