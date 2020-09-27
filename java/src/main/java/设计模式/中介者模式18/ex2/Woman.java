package 设计模式.中介者模式18.ex2;

public class Woman extends Person {

	public Woman(String name, int condition,Mediator mediator) {
		super(name, condition, mediator);
	}

	public void getPartner(Person person) {
		this.getMediator().setWoman(this);
		this.getMediator().getPartner(person);
	}
	
}
