package testInet03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 
 * 	接收端测试
 * 
 * 
 */
public class ReceiveTest {
	public static void main(String[] args) throws IOException {
		//1.接收端 定义port 与发送端一致
		DatagramSocket ds =new DatagramSocket(9999);
		//2.创建包对象
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);
		//3.接收
		ds.receive(dp);
		//4.拆包
		byte[] data = dp.getData();
		InetAddress address = dp.getAddress();
		int length = dp.getLength();
		//5.输出
		System.out.println("send from------> "+address.getHostName());
		System.out.println(new String(data,0,length));
		//6.释放资源
		ds.close();
	}
}
