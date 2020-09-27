package 设计模式.装饰模式08;

public class SwimCarDecorator extends CarDecorator {

	public SwimCarDecorator(Car car) {
		super(car);
	}

	public void show() {
		this.getCar().show();
		this.swim();
	}
	
	public void swim() {
		System.out.println("可以游");
	}

	public void run() {
		
	}

}
