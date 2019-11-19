package SystemPut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * 
 * 	��׼�����������
 * 		 public static final InputStream in:�ֽ���������������ȡ����¼�������
 * 			public static final int x;
 * 			InputStream is = System.in;
 * 			Scanner sc = new Scanner(System.in);
 * 		public static final PrintStream out:�ֽ�������������������������
 * 			System.out.println();
 * 
 * 	����
 * 	���ڱ�׼�����OutputStream��һ���ֽ������������ֻ������ֽڻ����ֽ����飬�����Ƕ�ȡ�������������ַ�����
 * 	���������������Ҫת�����ֽ����飺
 * 	������Ҫͨ����׼���������ַ������ѱ�׼�����ת����һ���ַ���������ɣ�OutputStreamWriter
 */
public class SystemInOutDemo {
	public static void main(String[] args) throws IOException {
		//1.�������������� ����ʹ�ø�Ч������
		BufferedReader bfReader = new BufferedReader(new FileReader("bw2.txt"));
		//2.������������� ʹ��OutputStreamWriter ֱ�ӿ�������ַ� ����Ҫתbyte
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		//3.��ȡ�ļ�
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
