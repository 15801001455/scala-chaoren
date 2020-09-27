package 设计模式.职责链模式19.com.ibeifeng.ex2;

public class CarBodyHandler extends CarHandler {

	public void HandlerCar() {
		System.out.println("组装车身");
		if(this.carHandler != null) {
			this.carHandler.HandlerCar();
		}
	}

}
