package 单例模式05;

public class Person4 {

	//构造函数私有化
	private Person4() {
	}

	private static Person4 person;

	//提供一个全局的静态方法
	public static Person4 getPerson() {
		if(person == null) {
			synchronized (Person4.class) {
				if(person == null) {
					person = new Person4();
				}
			}
			
		}
		return person;
	}
}
