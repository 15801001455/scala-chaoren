package 设计模式.简单工厂模式01;

public class FruitFactory {

	/*
	 * get方法，获得所有产品对象
	 * update jyc 8/5一般使用if else这种 调用起来比较方便
	 */
	public static Fruit getFruit(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(type.equalsIgnoreCase("apple")) {
			return Apple.class.newInstance();
		} else if(type.equalsIgnoreCase("banana")) {
			return Banana.class.newInstance();
		} else {
			System.out.println("找不到相应的实例化类");
			return null;
		}
	}
}
