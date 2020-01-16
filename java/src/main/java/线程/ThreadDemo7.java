package 线程;

class ThreadDemo7 {
	public static void main(String[] args) {
		TicketPool pool = new TicketPool();
		Saler1 s1 = new Saler1("Marry" , pool);
		Saler1 s2 = new Saler1("======>john" , pool);
		s1.start();
		s2.start();
	}
}

//票池
class TicketPool{
	private int tickets = 100 ;
	//从票池取票
	public synchronized int getTicket(){
		int ticket = tickets ;
		tickets -- ;
		return ticket ;
	}
}
//售票员
class Saler1 extends Thread{
	private TicketPool pool ;
	private String name ;
	public Saler1(String name , TicketPool pool){
		this.name = name ;
		this.pool = pool ;
	}

	public void run(){
		while(true){
			int no = pool.getTicket();
			if(no > 0){
				System.out.println(name + " : " + no);
			}
			else{
				return ;
			}
		}
	}
}

