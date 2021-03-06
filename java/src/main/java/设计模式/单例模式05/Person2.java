package 设计模式.单例模式05;
//懒汉式 多线程不能保证一个实例 见Person3
public class Person2 {

	private static Person2 person;
	
	//构造函数私有化
	private Person2() {
	}
	
	//提供一个全局的静态方法
	public static Person2 getPerson() {
		if(person == null) {
			person = new Person2();
		}
		return person;
	}
}
