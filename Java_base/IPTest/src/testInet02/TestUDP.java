package testInet02;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*  此类为UDP发送端：
 * 
 * 	使用UDP协议发送数据
 * 			1.创建发送端Socket对象
 * 			2.创建数据并打包
 * 			3.发送数据
 * 			4.释放资源
 * 	
 * 	DatagramSocket：此类表示用于发送和接收数据报数据包的套接字，基于UDP协议
 * 	构造：
 * 	DatagramSocket()  创建Socket对象并随机分配端口号 
 * 	DatagramSocket(int port) 创建Socket对象并指定端口号
 * 
 *  DatagramPacket数据打包类
 *	构造：
 *	DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
 */
public class TestUDP {
	public static void main(String[] args) throws IOException {
		//1.创建发送端Socket对象
		DatagramSocket DS = new DatagramSocket();
		//2.创建数据并打包
		String s = "Hello udp,i am coming！"; //创建数据
		byte[] bys=s.getBytes();//转为字节数组 
		int length = bys.length;
		InetAddress ia = InetAddress.getByName("DESKTOP-RLAFMOV");//发送给当前设备 这里暂定发送给自己
		int port = 8888; //端口号 相当于快递写人名
		DatagramPacket dPacket = new DatagramPacket(bys, length,ia,port);
		//3.发送数据
		DS.send(dPacket);
		//4.释放资源
		DS.close();
	}
}
