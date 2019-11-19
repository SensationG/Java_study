package test1;

import java.util.ArrayList;
import java.util.List;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List Listlist1 = new ArrayList();
	     Listlist1.add(0);
	     List Listlist2 = Listlist1;
	     System.out.println(Listlist1.get(0) instanceof Integer);
	     System.out.println(Listlist2.get(0) instanceof Integer);
	}
}
