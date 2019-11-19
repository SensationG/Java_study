package SystemPut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * 
 * 	标准输入输出流：
 * 		 public static final InputStream in:字节输入流，用来读取键盘录入的数据
 * 			public static final int x;
 * 			InputStream is = System.in;
 * 			Scanner sc = new Scanner(System.in);
 * 		public static final PrintStream out:字节输出流，将数据输出到命令行
 * 			System.out.println();
 * 
 * 	需求：
 * 	由于标准输出流OutputStream是一个字节输出流，所以只能输出字节或者字节数组，但我们读取到的数据则是字符串，
 * 	如果想进行输出还需要转换成字节数组：
 * 	我们想要通过标准输出流输出字符串，把标准输出流转换成一种字符输出流即可：OutputStreamWriter
 */
public class SystemInOutDemo {
	public static void main(String[] args) throws IOException {
		//1.创建输入流对象 这里使用高效输入流
		BufferedReader bfReader = new BufferedReader(new FileReader("bw2.txt"));
		//2.创建输出流对象 使用OutputStreamWriter 直接可以输出字符 不需要转byte
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		//3.读取文件
		String line;
		while((line = bfReader.readLine())!=null) {
			bWriter.write(line);
			bWriter.newLine();
		}
		
		//4.
		bfReader.close();
		bWriter.close();
	}
}
