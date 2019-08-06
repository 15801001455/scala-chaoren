package 单例模式05;

public class MainClass {
	public static void main(String[] args) {
		Person2 per = Person2.getPerson();
		Person2 per2 = Person2.getPerson();
		System.out.println(per == per2);

		Person per3 = Person.getPerson();
		Person per4 = Person.getPerson();
		System.out.println(per3 == per4);
	}
}
