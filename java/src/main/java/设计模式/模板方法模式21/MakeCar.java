package 设计模式.模板方法模式21;

/*
 * 组装车
 */
public abstract class MakeCar {
	//组装车头
	public abstract void makeHead();
	
	//组装车身
	public abstract void makeBody();
	
	//组装车尾
	public abstract void makeTail();

	/**
	 * 精华就在这里
	 */
	public void make() {
		this.makeHead();
		this.makeBody();
		this.makeTail();
	}
}
