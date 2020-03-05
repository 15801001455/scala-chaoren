package 设计模式.工厂方法模式02;

public class AppleFactory implements FruitFactory {

	public Fruit getFruit() {
		return new Apple();
	}

}
