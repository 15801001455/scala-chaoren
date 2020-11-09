package 设计模式.中介者模式18.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Person {
	private String name;
	private int condition;
	
	public abstract void getPartner(Person person);
	
}
