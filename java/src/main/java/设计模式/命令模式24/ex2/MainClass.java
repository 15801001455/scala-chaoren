package 设计模式.命令模式24.ex2;

public class MainClass {
	public static void main(String[] args) {
		Peddler peddler = new Peddler();
//		peddler.sailApple();
//		peddler.sailBanana();
		
		Command appleCommand = new AppleCommand(peddler);
		Command bananaCommand = new BananaCommand(peddler);
		appleCommand.sail();
		bananaCommand.sail();
	}
}
