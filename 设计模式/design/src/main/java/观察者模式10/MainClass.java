package 观察者模式10;

public class MainClass {
	public static void main(String[] args) {
		Person person = new Person();
		//注册观察者
		person.addObserver(new MyObServer());
		person.addObserver(new MyObServer());
		System.out.println(person.countObservers());
		person.setName("lifengxing");
		person.setAge(23);
		person.setSex("男");
	}
}
