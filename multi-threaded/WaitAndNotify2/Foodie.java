package WaitAndNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread {

    ArrayBlockingQueue<String> queue;

    public Foodie(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String food = queue.take();
                System.out.println("吃一碗");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
