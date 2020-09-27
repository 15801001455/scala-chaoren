package 设计模式.工厂模式的应用04;

public class AddOperationFactory implements OperationFactory{

	public Operation getOperation() {
		return new AddOperation();
	}
	
}
