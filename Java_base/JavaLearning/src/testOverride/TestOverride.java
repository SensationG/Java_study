package testOverride;


//测试方法重写
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
		super();//写与不写都会先构造父类
		System.out.println("sun create");
	}
	//这里的run重写了父类的run
	protected void run() {
		System.out.println("run no");
	}
	
}