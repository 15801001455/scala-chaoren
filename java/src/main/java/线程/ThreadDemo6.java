package 线程;

class ThreadDemo6 {
	public static void main(String[] args) 	{
		Saler3 s1 = new Saler3("==>老张");
		Saler3 s2 = new Saler3("=====>老王");
		s1.start();
		s2.start();
	}
}
class Saler3 extends Thread{
	//票数
	static int tickets = 100 ;
	private String name ;
	public Saler3(String name){
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

	//同步方法
	public static synchronized int getTicket(){
		//同步代码块
		int currTicket = tickets ;
		tickets -- ;
		return currTicket ;
	}
}
