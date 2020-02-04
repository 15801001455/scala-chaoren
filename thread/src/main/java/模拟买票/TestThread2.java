package 模拟买票;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 最正确的写法 TestThread和TestThread1都有问题 没有加锁
 */
class Window2 implements Runnable {
    private Integer ticketNum = 100;//代表10张票

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            int i = sellTicket();
            if(i < 0){
                break;
            }
        }

    }

    public int sellTicket() {
        lock.lock();//上锁的位置如何确定呢？就是要把上锁的代码包含过有共享变量的地方 这里就是ticketNum变量
        try{
            if (ticketNum > 0) {
                System.out.println(Thread.currentThread().getName() + "售票,票号：" + ticketNum--);//shift+空格控制搜狗输入法的全角和半角
                Thread.sleep(300);
                return 1;
            }else{
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return 1;
    }
}

public class TestThread2 {
    public static void main(String[] args) {
        Window2 w = new Window2();
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
