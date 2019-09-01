package 职责链模式19;

/**
 * 不好的方式，没有使用职责链
 */
public class MainClass {
	public static void main(String[] args) {
		CarHandler headH = new CarHeadHandler();
		CarHandler bodyH = new CarBodyHandler();
		CarHandler tailH = new CarTailHandler();
		
		headH.HandlerCar();
		bodyH.HandlerCar();
		tailH.HandlerCar();
	}
}
