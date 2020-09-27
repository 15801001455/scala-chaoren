package 设计模式.观察者模式10;

import java.util.Observable;
import java.util.Observer;


public class MyObServer implements Observer {

	public void update(Observable o, Object arg) {
		System.out.println("对象发生变化");
	}
}
