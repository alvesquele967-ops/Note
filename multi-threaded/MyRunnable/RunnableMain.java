package MyRunnable;

public class RunnableMain {
    public static void main(String[] args) {
        MyRun myrun = new MyRun();
        Thread t1 = new Thread(myrun);
        t1.setName("线程1");
        Thread t2 = new Thread(myrun);
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
