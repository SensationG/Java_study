package testInet02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.xml.crypto.Data;

/*
 * 
 * UDP协议接收端
 * 		1.创建接收端Socket对象
 * 		2.接收数据
 * 		3.解析数据（拆包）
 * 		4.输出数据
 * 		5.释放资源
 * 
 */
public class TestUDP02 {
	public static void main(String[] args) throws IOException {
		//1.创建接收端Socket对象
		DatagramSocket dSocket = new DatagramSocket(8888); //指定端口号
		//2.接收数据
		byte[] byt = new byte[1024];//new一个字节数组 用来接收数据 
		DatagramPacket dp = new DatagramPacket(byt, byt.length);//接收数据的包对象
		System.out.println("1");
		dSocket.receive(dp);//阻塞 等待数据过来
		System.out.println("2");
		//3.解析数据（拆包）
		InetAddress iAddress = dp.getAddress();//获取发送端的ip对象
		byte[] data = dp.getData();//获取接收到的数据，也可以直接使用创建包对象时的数组 这里是byt
		int length = dp.getLength();//获取具体收到数据的长度 长度用于下面输出 
		//4.输出数据
		 System.out.println("send----->"+iAddress.getHostAddress());//返回发件人ip
		 System.out.println(new String(data,0,length));//收到多少转多少，不然会有空字节 
		//5.释放资源
		 dSocket.close();
	}
}
