package MyRunnable;

import TheadMethod.MyThread;

public class MyRun implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //获取到当前线程的对象
            Thread t =Thread.currentThread();
            System.out.println(t.getName()+"启动");
//或            System.out.println(Thread.currentThread().getName());
        }
    }

}
