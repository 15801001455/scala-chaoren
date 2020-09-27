package 线程;

/**
 * 线程 yield的操作在什么情况下有效
 */
class ThreadDemo1{
	public static void main(String[] args) 	{		
		线程.MyThread t1 = new 线程.MyThread();
		YourThread t2 = new YourThread();
		//如果执行这句的话，永远不会执行t2线程的代码了感觉 在t2.start()这行打断点永远进不来 可见yield还是要配合线程的start方法使用,直接
		//调用线程的run方法,run方法中通过yield放弃cpu抢占权是无用的操作
		t1.run();
		//t1.start();
		t2.start();
	}
}

class MyThread extends Thread{
	//执行线程的时候进行调用,jvm负责调用
	public void run(){
		while(true){
			System.out.println("myThread");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			yield();		//放弃cpu的抢占权
		}
	}
}
//
class YourThread extends Thread{
	public void run(){
		while(true){
			System.out.println("yourThread");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			yield();
		}
	}
}
