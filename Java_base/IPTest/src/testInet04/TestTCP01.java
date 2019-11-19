package testInet04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/*
 * 	客户端（发送端）
 * 	使用TCP协议发送数据
 * 			1.创建发送端Socekt对象（创建连接） 
 * 			2.获取输出流对象（从Socket获取）
 * 			3.发送数据
 * 			4.释放资源
 * 
 * Socket(InetAddress address, int port) 创建流套接字并将其连接到指定IP地址的指定端口号。 
 */
public class TestTCP01 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.创建发送端Socket对象
		Socket s = new Socket(InetAddress.getByName("DESKTOP-RLAFMOV"),10089);
		//2.获取输出流对象（从Socket获取）
		OutputStream os = s.getOutputStream();
		//3.发送数据
		String str = "Hello ,this is TCP";
		os.write(str.getBytes());
		//4.释放资源
		//os.close();
		s.close();
	}
}
