package 策略模式09;

public class Context {
	private Strategy strategy;
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void encrypt() {
		this.strategy.encrypt();
	}
}
