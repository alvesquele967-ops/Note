package ThreadSafe2;

public class ThreadMain {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();


        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");



        t1.start();
        t2.start();
        t3.start();
    }
}
