package 设计模式.适配器模式16;

public class MainClass {
	public static void main(String[] args) {
//		Current current = new Current();
//		current.use220V();
		
//		Adapter adapter = new Adapter();
//		adapter.use18V();
		
		Adapter2 adapter = new Adapter2(new Current());
		adapter.use18V();
	}
}
