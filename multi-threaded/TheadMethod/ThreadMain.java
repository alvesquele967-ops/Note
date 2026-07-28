package TheadMethod;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread("线程1");
        MyThread myThread2 = new MyThread("线程2");
//        myThread1.start();
//        myThread2.start();

        myThread1.setPriority(1);
        myThread2.setPriority(10);

        System.out.println(myThread1.getPriority());
        System.out.println(myThread2.getPriority());
        //默认优先级为5,注意：优先级不是绝对的，依旧有概率会慢
        myThread1.start();
        myThread2.start();

    }

}
