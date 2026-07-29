package WaitAndNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {

    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                String food = "第" + i + "碗面条";

                System.out.println("厨师放置：" + food);
                queue.put(food);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("厨师下班了");
    }
}
