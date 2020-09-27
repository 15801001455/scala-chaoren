package 设计模式.桥接模式15;

public class Jeep extends Car {

	public Jeep(Engine engine) {
		super(engine);
	}

	public void installEngine() {
		System.out.print("Jeep：");
		this.getEngine().installEngine();
	}

}
