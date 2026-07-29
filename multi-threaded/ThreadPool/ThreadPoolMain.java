package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {
    public static void main(String[] args) throws InterruptedException {

        //获取线程池对象ctrl+alt+v(无上限的)
        ExecutorService pool1 = Executors.newCachedThreadPool();
        //有上限的线程池
        ExecutorService pool2 = Executors.newFixedThreadPool(3);

//        提交任务
        pool1.submit(new MyRunnable());
//        Thread.sleep(1000);
        pool1.submit(new MyRunnable());
//        Thread.sleep(1000);
        pool1.submit(new MyRunnable());
//        Thread.sleep(1000);
        pool1.submit(new MyRunnable());
//        Thread.sleep(1000);
        pool1.submit(new MyRunnable());
//        Thread.sleep(1000);

        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());

        //销毁线程池
        pool1.shutdown();
        pool2.shutdown();
    }
}
