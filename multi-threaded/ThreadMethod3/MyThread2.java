package ThreadMethod3;

public class MyThread2 extends Thread {

    public MyThread2() {
    }

    public MyThread2(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + " is running");
        }

    }
}
