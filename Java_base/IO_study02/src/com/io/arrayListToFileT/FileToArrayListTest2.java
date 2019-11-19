package com.io.arrayListToFileT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 *  1.把（上一题）FileToArrayList的文本文件中的学生信息读取出来存储到集合中，然后遍历集合，在控制台输出
 *  
 * 	分析：
 * 		1.定义学生类
 * 		2.创建输入缓冲流对象
 * 		3.创建集合对象
 * 		4.读取文件数据，并把数据按照一定的格式进行分割，赋值给学生对象，然后把学生对象作为元素存储到集合
 * 			格式举例：h001,黄浩韦华,20,厦门     
 * 		5.释放资源
 * 		6.遍历集合
 */
public class FileToArrayListTest2 {
	public static void main(String[] args) throws IOException {
		//创建输入缓冲流对象
		BufferedReader bReader = new BufferedReader(new FileReader("student.txt"));
		
		//创建集合文件
		ArrayList<Student> list = new ArrayList<>();
		
		//读取文件数据,按照格式分隔，以逗号作为分隔界限
		String len;
		while((len=bReader.readLine())!=null) {
			String[] strArray = len.split(","); //split()用法参照api 返回型是String[]
			Student s = new Student();
			s.setNum(strArray[0]);
			s.setName(strArray[1]);
			s.setAge(strArray[2]);
			s.setCity(strArray[3]);
			list.add(s);
		}
		
		//释放资源
		bReader.close();
		
		//遍历集合
		for(Student s:list) {
			System.out.println(s.getNum()+" "+s.getName()+" "+s.getAge()+" "+s.getCity());
		}
		
	}
}
