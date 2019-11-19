package test1;

public class ttt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		child ch = new child();
		ch.name="hhw";
		ch.rest();
	}
	
}

class father {
	String name;
	int height;
	public void rest() {
		System.out.printf("father fuck");
	}
}
class child extends father{
	int age;
	
}


