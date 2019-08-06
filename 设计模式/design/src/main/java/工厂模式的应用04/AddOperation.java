package 工厂模式的应用04;

public class AddOperation extends Operation {

	public double getResult() {
		double result = this.getNum1() + this.getNum2();
		return result;
	}
}
