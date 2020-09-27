package 设计模式.模板方法模式21;

public class MainClass {
	public static void main(String[] args) {
		MakeCar bus = new MakeBus();
		bus.make();
		
		System.out.println("-------------------");
		
		MakeCar jeep = new MakeJeep();
		jeep.make();

	}
}
