package ThreadMethod4;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " " + i);
            Thread.yield();
            //表示让出当前CPU的执行权（只是尽可能，还是会被抢回来）
        }
    }
}
