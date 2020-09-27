package 设计模式.状态模式23.com.ibeifeng.ex3;

public class NoState extends State {

	public void doSomething(Person person) {
		System.out.println(person.getHour() +  "未定义");
	}

}
