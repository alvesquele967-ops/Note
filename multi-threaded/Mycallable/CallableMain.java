package Mycallable;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableMain {
    public static void main(String[] args) throws Exception {
        Mycallable mycallable = new Mycallable();
//        创建FutureTask的对象（作用管理多线程运行的结果）
        FutureTask<Integer> ft = new FutureTask<>(mycallable);
        Thread t1 = new Thread(ft);
        t1.start();

        Integer result = ft.get();
        System.out.println(result);
    }
}
