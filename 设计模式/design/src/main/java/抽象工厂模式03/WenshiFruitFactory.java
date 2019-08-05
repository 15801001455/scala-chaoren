package 抽象工厂模式03;

public class WenshiFruitFactory implements FruitFactory {

	public Fruit getApple() {
		return new WenshiApple();
	}

	public Fruit getBanana() {
		return new WenshiBanana();
	}

}
