package 工厂方法模式02;

public class PearFactory implements FruitFactory {

	public Fruit getFruit() {
		return new Pear();
	}
}
