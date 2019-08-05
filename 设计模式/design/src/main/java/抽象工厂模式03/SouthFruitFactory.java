package 抽象工厂模式03;

public class SouthFruitFactory implements FruitFactory {

	public Fruit getApple() {
		return new SouthApple();
	}

	public Fruit getBanana() {
		return new SouthBanana();
	}

}
