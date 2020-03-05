package 设计模式.策略模式09;

public class MD5Strategy implements Strategy{

	public void encrypt() {
		System.out.println("执行MD5加密");
	}

}
