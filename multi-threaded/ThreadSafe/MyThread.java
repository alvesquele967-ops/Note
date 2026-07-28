package ThreadSafe;

public class MyThread extends Thread {

    static int ticket = 0;
    static Object lock = new Object();
    @Override
    public void run() {
        while (true){
            try {
                MyThread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            康住,或者拿上面的lock
            synchronized (MyThread.class) {
                if (ticket < 20){

                    ticket++;
                    System.out.println(getName()+"正在卖第"+ticket+"张");
                }else {
                    break;
                }
            }
        }
    }
}
