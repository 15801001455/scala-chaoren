package 设计模式.建造者模式07;

public class HouseDirector {
	
	public void makeHouse(HouseBuilder builder) {
		builder.makeFloor();
		builder.makeWall();
		builder.makeHousetop();
	}
	
}
