package 模拟买票;

//模拟火车站卖票 总共三个窗口 一共100张票（有共享数据的问题 应该用implements Runnable方式比较好 共享变量就不用加static修饰了 见TestThread1）

/**
 * 这个程序是有问题的 会出现多个窗口卖一张票的情况，不知道老师是不是没发现这个问题(应该用锁机制 看TestThread2) 输出如下
 * 窗口1售票,票号：10
 * 窗口3售票,票号：9
 * 窗口3售票,票号：7
 * 窗口3售票,票号：6
 * 窗口2售票,票号：10
 * 窗口3售票,票号：5
 * 窗口3售票,票号：3
 * 窗口3售票,票号：2
 * 窗口1售票,票号：8
 * 窗口3售票,票号：1
 * 窗口2售票,票号：4
 */
class Window extends Thread {
    //这里必须声明为static 类公用变量 要不new完三个窗口后，每个窗口就各个有100张票，总共300张票了，肯定就不对了，所以多个线程操作同一份数据更适合用Runnable，看TestThread1

    private static Integer ticketNum = 10;//代表10张票

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

public class TestThread {
    public static void main(String[] args) {
        Window w1 = new Window();
        w1.setName("窗口1");
        Window w2 = new Window();
        w2.setName("窗口2");
        Window w3 = new Window();
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
