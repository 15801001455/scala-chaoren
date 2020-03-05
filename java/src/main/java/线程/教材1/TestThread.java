package 线程.教材1;

class MyThread extends Thread{

    private String name;

    @Override
    public void run() {
        printOdd();
    }

    public void printOdd(){
        for(int i=0;i<10;i++){
            if(i % 2 == 0){
                System.out.println(this.name + i);
            }
        }
    }
    public MyThread(String name){
        this.name = name;
    }
}
public class TestThread {
    public static void main(String[] args) {
        MyThread myThead1 = new MyThread("one:");
        MyThread myThead2 = new MyThread("two:");
        myThead1.setPriority(Thread.MAX_PRIORITY);
        myThead2.setPriority(Thread.MIN_PRIORITY);
        myThead1.start();
        myThead2.start();
    }
}
