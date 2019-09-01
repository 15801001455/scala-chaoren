package 职责链模式19.com.ibeifeng.ex2;

public abstract class CarHandler {
	protected CarHandler carHandler;
	
	public CarHandler setNextHandler(CarHandler carHandler) {
		this.carHandler = carHandler;
		return this.carHandler;
	}
	
	public abstract void HandlerCar(); 
}
