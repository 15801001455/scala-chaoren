package 设计模式.桥接模式15;

public class Bus extends Car{

	public Bus(Engine engine) {
		super(engine);
	}

	public void installEngine() {
		System.out.print("Bus：");
		this.getEngine().installEngine();
	}
}
