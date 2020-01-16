package 线程;

class ThreadDemo5 {
	public static void main(String[] args) 	{
		Saler2 s1 = new Saler2("==>老张");
		Saler2 s2 = new Saler2("=====>老王");
		Saler2 s3 = new Saler2("===========>老赵");
		s1.start();
		s2.start();
		s3.start();
	}
}
class Saler2 extends Thread{
	//锁
	static Object lock = new Object();
	//票数
	static int tickets = 100 ;
	private String name ;
	public Saler2(String name){
		this.name = name ;
	}
	public void run(){
		while(true){
			int tick = getTicket();
			if(tick > 0){
				System.out.println(name + " : " + tick);
			}
			else{
				return ;
			}
		}
	}
	//取票
	public int getTicket(){
		//同步代码块
		synchronized(lock){
			int currTicket = tickets ;
			tickets -- ;
			return currTicket ;
		}
	}
}
