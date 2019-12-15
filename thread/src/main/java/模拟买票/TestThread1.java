package 模拟买票;

class Window1 implements Runnable {
    //这里必须声明为static 类公用变量 要不new完三个窗口后，每个窗口就各个有100张票，总共300张票了，肯定就不对了，所以多个线程操作同一份数据更适合用Runnable，看TestThread1

    private Integer ticketNum = 100;//代表10张票

    @Override
    public void run() {
        sellTicket();
    }

    public void sellTicket() {
        while (true) {
                if (ticketNum > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票,票号：" + ticketNum--);//shift+空格控制搜狗输入法的全角和半角
                } else {
                    break;
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
