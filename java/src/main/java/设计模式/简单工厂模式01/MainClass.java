package 设计模式.简单工厂模式01;

public class MainClass {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Fruit apple = FruitFactory.getFruit("简单工厂模式01.Apple");
		Fruit apple1 = FruitFactory.getFruit("简单工厂模式01.Apple");
		Fruit banana = FruitFactory.getFruit("简单工厂模式01.Banana");
		apple.get();
		banana.get();
	}
}
