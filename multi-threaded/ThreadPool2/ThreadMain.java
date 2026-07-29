package ThreadPool2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadMain {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
//                核心线程数量，能小于0
                3,
//                最大线程数，不能小于0，最大数量 >=核心线程数量
                6,
//                空闲线程最大存活时间
                60,
//                时间单位
                TimeUnit.SECONDS,
//                任务队列
                new ArrayBlockingQueue<>(3),
//                创建线程工厂
                Executors.defaultThreadFactory(),
//                任务的拒绝策略
                new ThreadPoolExecutor.AbortPolicy()


        );
    }
}
