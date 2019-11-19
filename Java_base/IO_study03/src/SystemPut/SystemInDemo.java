package SystemPut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * 
 * 	需求：读取键盘录入的数据，并输出到项目根目录下的a.txt文件中
 * 
 * 	数据源：读取键盘录入的数据 System.in
 * 	目的地：项目根目录下的a.txt 
 * 
 * 	使用转换流：需要把字节输入流转换成字符输出流 InputStreamReader
 */
public class SystemInDemo {
	public static void main(String[] args) throws IOException {
		//1.创建字节输入流对象
		InputStream iS = System.in; //标准输入流
		Reader r = new InputStreamReader(iS);//转换流 左边父类 右边子类
		//2.创建输出流对象
		FileWriter bWriter = new FileWriter("a.txt");
		//3.读取文件 未使用转换流的情况
		int len;
		char[] ch = new char[1024];
		while((len = r.read(ch))!=-1) {
			bWriter.write(ch,0,len);
			bWriter.flush();
		}
		//4.释放资源
		bWriter.close();
		bWriter.close();
	}
}
