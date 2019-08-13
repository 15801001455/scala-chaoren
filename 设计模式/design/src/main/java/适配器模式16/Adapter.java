package 适配器模式16;

public class Adapter extends Current{

	public void use18V() {
		System.out.println("使用适配器");
		this.use220V();
	}
}
