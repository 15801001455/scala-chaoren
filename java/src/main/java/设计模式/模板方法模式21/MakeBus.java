package 设计模式.模板方法模式21;

public class MakeBus extends MakeCar {

	public void makeBody() {
		System.out.println("bus:组装车身");
	}

	public void makeHead() {
		System.out.println("bus:组装车头");
	}

	public void makeTail() {
		System.out.println("bus:组装车尾");
	}
}
