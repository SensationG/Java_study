package testInet06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

/*
 * 
 * 模拟用户登陆
 * 
 * 客户端
 * 
 * 
 */
public class ClientTest {
	public static void main(String[] args) throws IOException {
		//1.创建客户端Socket对象
		//Socket s = new Socket(InetAddress.getByName("DESKTOP-RLAFMOV"),10092);
		Socket s = new Socket("DESKTOP-RLAFMOV",10092);
		//2.获取用户名和密码(一次读一行，一行用户名一行密码)
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String username = bReader.readLine();
		System.out.println("请输入密码：");
		String password = bReader.readLine();
		//3.获取输入流对象（使用打印流，可换行+自动刷新）
		PrintWriter outWriter = new PrintWriter(s.getOutputStream(),true);
		//4.写出数据(让服务器读两行)
		outWriter.println(username);
		outWriter.println(password);
		//5.获取输入流对象
		InputStream is = s.getInputStream();
		//6.获取服务器返回的数据
		byte[] bys = new byte[1024];
		int len;
		len = is.read(bys);
		System.out.println(new String(bys,0,len));
		//7.释放资源
		s.close();
	}
}
