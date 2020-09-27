package 设计模式.命令模式24.ex2;

public abstract class Command {
	private Peddler peddler;
	
	
	public Command(Peddler peddler) {
		this.peddler = peddler;
	}
	
	public Peddler getPeddler() {
		return peddler;
	}

	public void setPeddler(Peddler peddler) {
		this.peddler = peddler;
	}

	public abstract void sail();
}
