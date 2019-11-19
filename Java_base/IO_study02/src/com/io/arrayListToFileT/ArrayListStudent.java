package com.io.arrayListToFileT;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * 需求：键盘录入3个学生信息（学号，姓名，年龄，居住地）存入集合。然后遍历集合把学生信息存入txt
 * 		（每一个学生信息为一行数据，自定义分割标记）
 * 
 * 分析：
 * 		1.定义学生类
 * 		2.创建集合对象
 * 		3.写方法实现键盘录入学生信息，并把学生对象作为元素添加到集合
 * 		4.创建输出缓冲流对象
 * 		5.遍历集合，得到每一个学生信息，并把学生信息按照一定的格式写入文本文件（以逗号作为分隔符）
 * 			格式举例：h001,黄浩韦华,20,厦门     
 * 		6.释放资源
 */
public class ArrayListStudent {
	public static void main(String[] args) throws IOException {
	
		//创建集合对象
		ArrayList<Student> l1 = new ArrayList<>();
		addStudent(l1);
		addStudent(l1);
		addStudent(l1); //重复3遍即可录入3个对象
	
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("student.txt"));
		
		//遍历集合
		for(Student a:l1) {
			//使用append拼接（保证格式）
			StringBuilder sb = new StringBuilder();
			sb.append(a.getNum()).append(",").append(a.getName()).append(",").append(a.getAge()).append(",").append(a.getCity());
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//释放资源
		bw.close();
	}
		
	private static void addStudent(ArrayList<Student> list) {
		//1.录入学生信息
		Scanner sc = new Scanner(System.in);
		
		//2.为了让num能够被访问到，把num定义在循环外面
		String num;
		
		//3.为了能让代码回到这里，用循环 判断学号有没被使用
		boolean flag = false;
		while(true) {
			System.out.println("请输入学生学号");
			num = sc.nextLine();
			for(Student a:list) {
				if(num==a.getNum()) { //学号被占用
					flag = true; 
					break;
				}
			}
			
			if(flag) {
				System.out.println("你输入的学号已经被占用，请重新输入：");
			}else {
				break;
			}
		}
		
		System.out.println("请输入学生姓名：");
		String name =sc.nextLine();
		System.out.println("请输入学生年龄：");
		String age = sc.nextLine();
		System.out.println("请输入学生地址：");
		String city = sc.nextLine();
		
		//创建学生对象
		Student st1 = new Student();
		st1.setNum(num);
		st1.setName(name);
		st1.setAge(age);;
		st1.setCity(city);
		
		//把学生对象加入集合
		list.add(st1);
		
		System.out.println("succeed");
		
	}

}
