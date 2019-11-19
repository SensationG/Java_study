package testInet05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 * 服务端
 * 
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//1.服务端对象
		ServerSocket ss = new ServerSocket(7070);
		//2.监听客户端是否连接
		Socket sk = ss.accept();
		//3.输入流对象
		InputStream is = sk.getInputStream();	
		//4.获取数据
		byte[] data = new byte[1024];
		int len;
		len = is.read(data);		
		//转换数据
		String str = new String(data,0,len);
		//5.输出数据
		System.out.println(str);
		//处理数据
		String upperStr = str.toUpperCase();
		//如何把服务端信息返回客户端？客户端如何写过来，写回去即可
		//获取输出流对象 
		OutputStream os = sk.getOutputStream();
		//返回数据
		os.write(upperStr.getBytes());
		
		//6.释放资源
		sk.close();
	}
}
