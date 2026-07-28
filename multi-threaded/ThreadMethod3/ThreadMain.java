package ThreadMethod3;

//当其他的非守护线程执行完毕之后，守护线程会陆续结束
public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadMethod3.MyThread myThread1 = new MyThread("线程1");
        MyThread2 myThread2 = new MyThread2("线程2");
        //设置为守护线程
        myThread2.setDaemon(true);
        myThread1.start();
        myThread2.start();
//        输出结果例如：
//        线程2 is running
//        线程1@0
//        线程2 is running
//        线程1@1
//        线程1@2
//        线程2 is running
//        线程2 is running
//        线程1@3
//        线程2 is running
//        线程1@4
//                可以看到线程1结束之后，身为守护线程的线程2还没遍历完就也跟着结束了

    }

}
