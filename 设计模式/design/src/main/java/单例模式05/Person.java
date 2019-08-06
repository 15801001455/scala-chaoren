package 单例模式05;
//饿汉式
public class Person {

	//构造函数私有化
	private Person() {
	}

	private static final Person person = new Person();


	
	//提供一个全局的静态方法
	public static Person getPerson() {
		return person;
	}
}
