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
 * 	���󣺶�ȡ����¼������ݣ����������Ŀ��Ŀ¼�µ�a.txt�ļ���
 * 
 * 	����Դ����ȡ����¼������� System.in
 * 	Ŀ�ĵأ���Ŀ��Ŀ¼�µ�a.txt 
 * 
 * 	ʹ��ת��������Ҫ���ֽ�������ת�����ַ������ InputStreamReader
 */
public class SystemInDemo {
	public static void main(String[] args) throws IOException {
		//1.�����ֽ�����������
		InputStream iS = System.in; //��׼������
		Reader r = new InputStreamReader(iS);//ת���� ��߸��� �ұ�����
		//2.�������������
		FileWriter bWriter = new FileWriter("a.txt");
		//3.��ȡ�ļ� δʹ��ת���������
		int len;
		char[] ch = new char[1024];
		while((len = r.read(ch))!=-1) {
			bWriter.write(ch,0,len);
			bWriter.flush();
		}
		//4.�ͷ���Դ
		bWriter.close();
		bWriter.close();
	}
}
