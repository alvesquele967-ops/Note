package WaitAndNotify;

public class WaitThread extends Thread {

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock){
                if(Desk.foodCount == 0){
                    break;
                }else {
                    if (Desk.foodFlag == 0){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        Desk.foodCount--;
                        System.out.println("正在使用，还剩:"+Desk.foodCount);
                        Desk.lock.notifyAll();
                        Desk.foodFlag = 0;
                        //唤醒跟这把锁绑定的所有线程
                    }
                }
            }
        }
    }
}
