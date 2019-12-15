package 模拟买票;

//模拟火车站卖票 总共三个窗口 一共100张票（有共享数据的问题 应该用implements Runnable方式比较好 共享变量就不用加static修饰了 见TestThread1）
class Window extends Thread {
    //这里必须声明为static 类公用变量 要不new完三个窗口后，每个窗口就各个有100张票，总共300张票了，肯定就不对了，所以多个线程操作同一份数据更适合用Runnable，看TestThread1

    private static Integer ticketNum = 10;//代表10张票

    //错误的锁obj,如果是implement Runnable就没问题了 因为new多个线程的时候用的同一个Window对象
    //Object obj = new Object();//注意让obj当锁是严重错误的 还会出现重票问题！！！！！用Window.class当锁？可以 用this呢？不可以,因为main new了三个Wndow对象,this代表当前对象
    static Object obj = new Object();//加了static才能充当锁

    @Override
    public void run() {
        while(true){
            sellTicket();
        }

    }

    public void sellTicket() {
        synchronized (obj){//加锁的位置在哪里呢？就是包裹住共享变量的地方
            if (ticketNum > 0) {
                System.out.println(Thread.currentThread().getName() + "售票,票号：" + ticketNum--);//shift+空格控制搜狗输入法的全角和半角
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
