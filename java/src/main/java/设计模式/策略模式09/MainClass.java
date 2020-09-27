package 设计模式.策略模式09;

public class MainClass {
	public static void main(String[] args) {
//		Strategy stra = new MDSStrategy();
//		stra.encrypt();
		Context context = new Context(new MDSStrategy());
		context.encrypt();
	}
}
