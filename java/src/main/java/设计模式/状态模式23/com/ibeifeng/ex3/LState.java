package 设计模式.状态模式23.com.ibeifeng.ex3;

public class LState extends State{

	public void doSomething(Person person) {
		if(person.getHour() == 12) {
			System.out.println("吃中饭");
		} else {
			person.setState(new SState());
			person.doSomething();
		}
	}

}
