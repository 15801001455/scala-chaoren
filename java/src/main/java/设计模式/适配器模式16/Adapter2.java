package 设计模式.适配器模式16;

public class Adapter2 {
	private Current current;
	
	public Adapter2(Current current) {
		this.current = current;
	}
	
	public void use18V() {
		System.out.println("使用适配器");
		this.current.use220V();
	}
}
