package 享元模式11;

public class MyCharacter {
	private char mychar;
	
	public MyCharacter(char mychar) {
		this.mychar = mychar;
	}
	
	public void display() {
		System.out.println(mychar);
	}
}
