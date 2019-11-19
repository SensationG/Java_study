package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cifang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = null;
		int i=0;
		List<Integer> list1 = new ArrayList<Integer>();
		System.out.print("Please input word: ");
		while(sc.hasNextInt()) {	//输入任意非数字退出循环			
			list1.add(sc.nextInt());
		}
		for(Integer j:list1)
		{
			System.out.print(j);
		}

}
}
