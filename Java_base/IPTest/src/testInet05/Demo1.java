package testInet05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 
 * 	需求：使用TCP协议发送数据，并将接收到的数据转换成大写并返回
 * 
 * 	客户端
 * 
 */
public class Demo1 {
	public static void main(String[] args) throws IOException, IOException {
		//1.tcp协议 发送目标
		Socket sk = new Socket(InetAddress.getByName("DESKTOP-RLAFMOV"), 7070);
		//2.数据输出流对象 
		OutputStream ops = sk.getOutputStream();
		//3.发送数据
		ops.write("hello,this is a tcp test".getBytes());
		//接收数据 输入流对象
		InputStream is = sk.getInputStream();
		byte[] bys = new byte[1024];
		int len;
		len = is.read(bys);
		System.out.println(new String(bys,0,len));
		//4.释放资源
		sk.close();
	}
}
