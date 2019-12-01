package simple1;
//爬楼梯问题，每次爬1阶或2阶，求几种爬法
public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sstairs sstairs = new Sstairs();
		int stairs=45;//一共要爬的楼梯数
		int a = sstairs.climbStairs(stairs);
		System.out.println(a);
	}
	
	
}
//	递归 暴力破解 时间复杂度2的n次方
class Sstairs {
	public int climbStairs(int n) {
	     int i=climb_Stairs(0, n);
	     return i;
	}
	public int climb_Stairs(int i, int n) { 
	  if (i > n) { //如果登完台阶发现超出，则返回0 此条不满足
	      return 0;
	  }
	  if (i == n) { //如果登完台阶发现刚好符合，则返回1，计算为1次
	      return 1;
	  }
	  return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n); //每次尝试登1阶台阶或者2阶台阶
	}
}
