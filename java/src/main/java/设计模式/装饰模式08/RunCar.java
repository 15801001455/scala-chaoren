package 设计模式.装饰模式08;

public class RunCar implements Car {

	public void run() {
		System.out.println("可以跑");
	}

	public void show() {
		this.run();
	}

}
