package testInet06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 * 服务器端
 * 
 */
public class ServerTest {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10092);
		//监听
		Socket s = ss.accept();
		//输入流对象
		BufferedReader bReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//读取data 一次读取一行
		String username = bReader.readLine();
		String password = bReader.readLine();
		//判断
		boolean flag = false; //密码判断 默认为false 就不用写else
		if("hhw2019".equals(username) || "hhw1234".equals(password)) {
			flag = true;
		}
		//返回信息 new 输出流
		OutputStream os = s.getOutputStream();
		if(flag) {
			os.write("登陆成功".getBytes());
		}else {
			os.write("登陆失败".getBytes());
		}
		//释放资源
		s.close();
		ss.close();
	}
}
