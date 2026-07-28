package ThreadMethod5;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread.setName("线程1");
        myThread2.setName("线程2");

        myThread.start();
        myThread2.start();

        myThread.join();
//        你myThread叔叔直接一手插入线程你不炸了吗？
//        666，线程2也在抢你气不气

        for (int i = 0; i < 10; i++) {
            System.out.println("main");
        }
//        main进程直接一手抢夺好吧
//        急哭了

    }
}
