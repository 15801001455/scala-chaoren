package 线程.教材1.模拟买票;

/**
 * 发现implentents Runnable比extends Thread优雅多了 implement方式需要线程类都加上static，连锁都要加上static，太费事了还容易出错
 */
class Window1 implements Runnable {

    private Integer ticketNum = 10;//代表10张票

    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            sellTicket();
        }
    }

    public void sellTicket() {
        synchronized (obj){
            if (ticketNum > 0) {
                System.out.println(Thread.currentThread().getName() + "售票,票号：" + ticketNum--);//shift+空格控制搜狗输入法的全角和半角
            }
        }

    }
}

public class TestThread1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}
