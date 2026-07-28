package ThreadSafe;

public class ThreadMain {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread.setName("窗口1");
        myThread2.setName("窗口2");
        myThread3.setName("窗口3");

        myThread.start();
        myThread2.start();
        myThread3.start();


    }
}
