package testOverride;


//���Է�����д
public class TestOverride {
	public static void main(String[] args) {
		Horse horse = new Horse();
		horse.run();
	}
}


class Vehicle{
	public Vehicle() {
		System.out.println("father create");
	}
	protected void run() {
		System.out.println("run rigth now");
	}
	public void stop() {
		System.out.println("stop right now");
	}
	
}

class Horse extends Vehicle{
	public Horse() {
		super();//д�벻д�����ȹ��츸��
		System.out.println("sun create");
	}
	//�����run��д�˸����run
	protected void run() {
		System.out.println("run no");
	}
	
}