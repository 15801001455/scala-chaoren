package 设计模式.访问者模式25;

/*
 * 访问者
 */
public interface Visitor {
	public void visit(Park park);
	public void visit(ParkA parkA);
	public void visit(ParkB parkB);
}
