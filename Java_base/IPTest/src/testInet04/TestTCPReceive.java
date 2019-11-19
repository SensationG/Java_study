package testInet04;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 	服务端（接收端）
 * 	使用TCP协议接收数据
 * 			1.创建接收端Socket对象
 * 			2.监听 （等待发送端客户端连接）
 * 			3. 输入流对象接收
 * 			4.获取数据
 * 			5.输出数据
 * 			6.释放资源
 * 
 */
public class TestTCPReceive {
	public static void main(String[] args) throws IOException {
		//1.创建接收端Socket对象
		ServerSocket ss = new ServerSocket(10089);
		//2.监听 （等待发送端客户端连接）
		Socket s = ss.accept();
		//3. 输入流对象接收
		InputStream is = s.getInputStream();
		//4.获取数据
		byte[] bys = new byte[1024];
		int len;//	用于存储读到的字节个数
		len = is.read(bys);//一次读取一个字符数组 
		//5.输出数据
		System.out.println(new String(bys,0,len));
		//6.释放资源
		s.close();
		//ss.close();//服务器端一般不关
	}
}
