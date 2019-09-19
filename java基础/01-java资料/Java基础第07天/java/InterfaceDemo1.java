class InterfaceDemo1 {
	public static void main(String[] args) 	{
		PC pc = new PC();
		Mouse m = new Mouse();
		pc.insertUSB(m);
	}
}
class PC{
	public void insertUSB(USB usb){
		System.out.println("插入了usb设备");
		usb.play();
	}
}
//定义接口
interface USB{
	void play() ;
}
//类实现了接口
class Mouse implements USB{
	public void play(){
		System.out.println("鼠标滑动");
	}
}


Computer
-------------
	