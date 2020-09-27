package 设计模式.模板方法模式21;

public class MakeJeep extends MakeCar {

	public void makeBody() {
		System.out.println("jeep:组装车身");
	}

	public void makeHead() {
		System.out.println("jeep:组装车头");
	}

	public void makeTail() {
		System.out.println("jeep:组装车尾");
	}

}
