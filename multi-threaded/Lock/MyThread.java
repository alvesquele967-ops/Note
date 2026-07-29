package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{


    static int ticket = 0;
    static Lock lock = new ReentrantLock(true);
    //非公平锁可能会导致刚释放锁就被又被抢

    @Override
    public void run() {
        while(true){
            lock.lock();
            try {
                if(ticket == 100){
                    break;
                }else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    ticket++;
                    System.out.println(getName() + " " + ticket);
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
