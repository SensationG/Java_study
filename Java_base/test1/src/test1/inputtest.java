package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//±ê×¼ÊäÈë·¶Àı
		 int m;
	        double sum,n;
	        Scanner sc = new Scanner(System.in);
	        while(sc.hasNext()){
	            n=sc.nextInt();
	            m=sc.nextInt();
	            sum=0;
	            for(int i=0;i<m;i++){
	                sum=sum+n;
	                n=Math.sqrt(n);
	            }
	            System.out.printf("%.2f",sum);
	            System.out.println();
	        };
	}

}
