package 线程;

class ThreadDemo3 {
	public static void main(String[] args) 	{
		Room r1 = new Room("no1",5000);
		Waiter w = new Waiter();
		//设置线程为守护线程
		//w.setDaemon(true);
		r1.start();
		w.start();
	}
}
class Room extends Thread{
	private String no ;
	private int time ;
	public Room(String no,int time){
		this.no = no ;
		this.time = time ;
	}
	public void run(){
		System.out.println(no + "号房间正在唱歌!");
		try{
			Thread.sleep(time);
		}
		catch(Exception e){
		}
		System.out.println(no + "号房间买单了，走人了!");
	}
}
//服务员
class Waiter extends Thread{
	public Waiter(){
		//update jyc 也可以在构造方法中设置守护线程 我的理解是主线程结束了，守护线程也会自动结束，while(true)里面的代码自动跳出终止
		this.setDaemon(true);
	}
	public void run(){
		while(true){
			System.out.println(new java.util.Date());
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){
			}
		}
	}
}
