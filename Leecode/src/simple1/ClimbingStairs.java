package simple1;
//��¥�����⣬ÿ����1�׻�2�ף���������
public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sstairs sstairs = new Sstairs();
		int stairs=45;//һ��Ҫ����¥����
		int a = sstairs.climbStairs(stairs);
		System.out.println(a);
	}
	
	
}
//	�ݹ� �����ƽ� ʱ�临�Ӷ�2��n�η�
class Sstairs {
	public int climbStairs(int n) {
	     int i=climb_Stairs(0, n);
	     return i;
	}
	public int climb_Stairs(int i, int n) { 
	  if (i > n) { //�������̨�׷��ֳ������򷵻�0 ����������
	      return 0;
	  }
	  if (i == n) { //�������̨�׷��ָպ÷��ϣ��򷵻�1������Ϊ1��
	      return 1;
	  }
	  return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n); //ÿ�γ��Ե�1��̨�׻���2��̨��
	}
}
