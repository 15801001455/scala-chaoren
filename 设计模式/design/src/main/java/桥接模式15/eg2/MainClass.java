package 桥接模式15.eg2;

public class MainClass {
	public static void main(String[] args) {
		Car car1 = new Bus();
		car1.install2000Engine();
	}
}
