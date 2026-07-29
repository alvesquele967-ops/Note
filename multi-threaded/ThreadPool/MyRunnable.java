package ThreadPool;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        //100.fori
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }

    }
}
