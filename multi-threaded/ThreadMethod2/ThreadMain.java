package ThreadMethod2;

import TheadMethod.MyThread;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread("线程1");
        MyThread myThread2 = new MyThread("线程2");
        myThread1.start();
        myThread2.start();

//        哪条线程执行到这个方法，获取的就是哪条线程的对象
//        Thread t = Thread.currentThread();
//        String name = t.getName();
//        System.out.println(name);

//        哪条线程执行到这个方法，就会停留对应的时间，单位为毫秒

//        System.out.println("Hello World");
//        Thread.sleep(3000);
//        System.out.println("AfterSleep");
    }

}
