package 设计模式.工厂方法模式02;

public class BananaFactory implements FruitFactory {

	public Fruit getFruit() {
		return new Banana();
	}

}
