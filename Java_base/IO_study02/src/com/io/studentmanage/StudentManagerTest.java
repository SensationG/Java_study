package com.io.studentmanage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.io.arrayListToFileT.Student;

/*
 * 	学生管理系统主类
 * 
 * 	步骤：
 * 		1.定义学生类
 * 		2.学生管理系统主界面代码编写
 * 		3.学生管理系统的查看所有学生的代码编写
 * 		4.添加学生功能
 * 		5.删除学生功能
 * 		6.修改学生功能
 * 
 */
public class StudentManagerTest {
	public static void main(String[] args) throws IOException {
		//	定义文件路径
		String fileName = "student1.txt";
		
		//	主选择程序
		while(true) {
			//	这是学生管理系统的主界面
			System.out.println("---------welcome to studentmanagement-------");
			System.out.println("1查看所有学生");
			System.out.println("2添加学生");
			System.out.println("3删除学生");
			System.out.println("4修改学生");
			
			//	键盘录入对象
			Scanner scanner = new Scanner(System.in);
			String choicString = scanner.nextLine();
			
			//	使用switch选择
			switch (choicString) {
			case "1":
				//	查看所有学生
				findAllStudent(fileName);
				break;
			case "2":
				//	添加学生
				addStudent(fileName);
				break;
			case "3":
				deleteStudent(fileName);
				break;
			case "4":
				updateStudent(fileName);
				break;
			default:
				System.out.println("thany you for you using");
				System.exit(0); //JVM退出
				break;
			}
				
		}
	}
	
		//	从文件中读数据到集合     把数据从哪个文件传到哪个集合
		private static void readData(String fileName,ArrayList<Student> list) throws IOException {
			//	创建输入缓冲流对象
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line;
			while((line=br.readLine())!=null) {
				String[] datas = line.split(",");
				Student s = new Student();
				s.setNum(datas[0]);
				s.setName(datas[1]);
				s.setAge(datas[2]);
				s.setCity(datas[3]);
				list.add(s);
			}
			br.close();
		}
	
		//	把集合中的数据写入文件
		public static void writeData(String fileName,ArrayList<Student> array) throws IOException {
			//创建输出缓冲流对象
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			
			for(Student s:array) {
				StringBuilder sb = new StringBuilder();
				sb.append(s.getNum()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getCity());
		
				bw.write(sb.toString());
				bw.newLine();
				bw.flush();
			}
			
			bw.close();
		}
		
		//	查看所有学生
		public static void findAllStudent(String fileName) throws IOException {
			//	创建集合对象
			ArrayList<Student> list = new ArrayList<Student>();
			
			//	从文件读数据到集合中
			readData(fileName, list);
			
			//	首先来判断集合中是否有数据，如果没有数据，就给出提示，并让该方法不继续往下执行
			if(list.size() == 0) {
				System.out.println("不好意思,目前没有学生信息可供查询,请回去重新选择你的操作");
				return;
			}
			
			//\t 其实就是一个tab键的位置
			System.out.println("学号\t姓名\t年龄\t居住地");
			for(Student s:list) {
				System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getCity());
			}
		}
		
		//	添加学生
		private static void addStudent(String fileName) throws IOException {
			//	创建集合对象
			ArrayList<Student> list = new ArrayList<Student>();
			
			//	从文件读数据到集合中
			readData(fileName, list);
			
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
			
			//	创建学生对象
			Student st1 = new Student();
			st1.setNum(num);
			st1.setName(name);
			st1.setAge(age);;
			st1.setCity(city);
			
			//	把学生对象加入集合
			list.add(st1);
			
			//	把集合中的数据重新写回文件
			writeData(fileName, list);
			System.out.println("succeed");
		}
		
		//	删除学生
		public static void deleteStudent(String fileName) throws IOException {
			
			//	创建集合对象
			ArrayList<Student> array = new ArrayList<Student>();
			//	从文件中把数据读取到集合中
			readData(fileName, array);
			
			//删除学生的思路：键盘录入一个学号，到集合中去查找，看是否有学生使用的是该学号，如果有就删除该学生
			//创建键盘录入对象
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入你要删除的学生的学号：");
			String id = sc.nextLine();
			
			//	我们必须给出学号不存在的时候的提示
			
			//	定义一个索引
			int index = -1;
			
			//	遍历集合
			for(int x=0; x<array.size(); x++) {
				//	获取到每一个学生对象
				Student s = array.get(x);
				//	拿这个学生对象的学号和键盘录入的学号进行比较
				if(s.getNum().equals(id)) {
					index = x;
					break;
				}
			}
			
			if(index == -1) {
				System.out.println("不好意思,你要删除的学号对应的学生信息不存在,请回去重新你的选择");
			}else {
				array.remove(index);
				//	把集合中的数据重新写回到文件
				writeData(fileName, array);
				System.out.println("删除学生成功");
			}	
		}
		
		//	修改学生
		public static void updateStudent(String fileName) throws IOException {
			//	创建集合对象
			ArrayList<Student> array = new ArrayList<Student>();
			//	从文件中把数据读取到集合中
			readData(fileName, array);
			
			//	修改学生的思路：键盘录入一个学号，到集合中去查找，看是否有学生使用的是该学号，如果有就修改该学生
			//	创建键盘录入对象
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入你要修改的学生的学号：");
			String id = sc.nextLine();
			
			//	定义一个索引
			int index = -1;
			
			//	遍历集合
			for(int x=0; x<array.size(); x++) {
				//	获取每一个学生对象
				Student s = array.get(x);
				//	拿学生对象的学号和键盘录入的学号进行比较
				if(s.getNum().equals(id)) {
					index = x;
					break;
				}
			}
			
			if(index == -1) {
				System.out.println("不好意思,你要修改的学号对应的学生信息不存在,请回去重新你的选择");
			}else {
				System.out.println("请输入学生新姓名：");
				String name = sc.nextLine();
				System.out.println("请输入学生新年龄：");
				String age = sc.nextLine();
				System.out.println("请输入学生新居住地：");
				String address = sc.nextLine();
				
				//	创建学生对象
				Student s = new Student();
				s.setNum(id);
				s.setName(name);
				s.setAge(age);
				s.setCity(address);
				
				//	修改集合中的学生对象
				array.set(index, s);
				//	把集合中的数据重新写回到文件
				writeData(fileName, array);
				//	给出提示
				System.out.println("修改学生成功");
			}
		}
		
	
}
