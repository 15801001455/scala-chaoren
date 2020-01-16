package 线程;

/**
 * update jyc 这个程序 老王这个售票员始终卖不出去票，想想为什么？ 因为Saler类中 static Object lock = new Object(); 这个lock对象用static修饰了
 * 想想为什么?
 */
class ThreadDemo4 {
	public static void main(String[] args) 	{
		Saler s1 = new Saler("老张*******");
		Saler s2 = new Saler("老王-------");
		s1.start();
		s2.start();
	}
}

class Saler extends Thread{
	//锁
	static Object lock = new Object();
	//update jyc 这个票数必须加static修饰
	static int tickets = 100 ;
	private String name ;
	public Saler(String name){
		this.name = name ;
	}

	public void run(){
		synchronized(lock){
			while(tickets > 0){
				int currTicket = tickets ;
				tickets = tickets - 1 ;
				System.out.println(name  + " : " + currTicket);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
