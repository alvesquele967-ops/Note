package WaitAndNotify;

public class ThreadMain {
    public static void main(String[] args) {
        NotifyThread notifyThread = new NotifyThread();
        WaitThread waitThread = new WaitThread();

        notifyThread.setName("生产者");
        waitThread.setName("消费者");

        notifyThread.start();
        waitThread.start();
    }
}
