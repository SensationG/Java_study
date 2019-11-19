package testInet03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 	发送端测试
 * 
 * 
 */
public class SendTest {
	public static void main(String[] args) throws IOException {
		//1.发送端对象
		DatagramSocket ds = new DatagramSocket();
		//2.打包
		byte[] bys = "Helloooo,this is UDP".getBytes();
		InetAddress iAddress = InetAddress.getByName("DESKTOP-RLAFMOV");
		DatagramPacket dp = new DatagramPacket(bys, bys.length, iAddress, 9999);
		//3.发送
		ds.send(dp);
		//4.释放
		ds.close();
	}
}
